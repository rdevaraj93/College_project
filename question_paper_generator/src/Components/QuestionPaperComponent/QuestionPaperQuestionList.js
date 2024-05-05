import React, { useEffect, useState } from 'react'
import TopNav from '../Login/TopNav'
import axios from 'axios';
import { Navigate, Outlet, useNavigate, useParams } from 'react-router-dom';
import { Collapse } from 'react-bootstrap';
import '../Login/Login.css'

function QuestionPaperQuestionList() {

    const { id } = useParams();
    const [examdetails, setExamdetails] = useState([]);
    const [examQuestiondetails, setExamQuestiondetails] = useState([]);

    const [examQuestiononeMark, setExamQuestiononeMark] = useState([]);
    const [examQuestiontwoMark, setExamQuestiontwoMark] = useState([]);
    const [examQuestionfiveMark, setExamQuestionfiveMark] = useState([]);
    const [examQuestiontenMark, setExamQuestiontenMark] = useState([]);


    console.log('Question paper question list id' + id)

    useEffect(() => {

        axios.get('http://localhost:8080/generate/getexamList/' + id)
            .then(res => {
                console.log(res.data)
                setExamdetails(res.data)
                console.log(examdetails)
                console.log('hellow')
            })
            .catch(err => console.log(err))

        axios.get('http://localhost:8080/generate/getexamquestion/' + id)
            .then(res => {
                console.log(res.data)
                setExamQuestiondetails(res.data)
            })
            .catch(err => console.log(err))

        const dataCategoryonemark = examQuestiondetails.filter((item) => item.questionweightid === 1);
        const dataCategorytwomark = examQuestiondetails.filter((item) => item.questionweightid === 2);
        const dataCategoryfivemark = examQuestiondetails.filter((item) => item.questionweightid === 3);
        const dataCategorytenmark = examQuestiondetails.filter((item) => item.questionweightid === 4);

        setExamQuestiononeMark(dataCategoryonemark);
        setExamQuestiontwoMark(dataCategorytwomark);
        setExamQuestionfiveMark(dataCategoryfivemark);
        setExamQuestiontenMark(dataCategorytenmark);

        console.log(examQuestiononeMark)
        console.log(examQuestiontwoMark)
        console.log(examQuestionfiveMark)
        console.log(examQuestiontenMark)

    })


    //const combinedArray = [...examQuestiononeMark, ...examQuestiontwoMark, ...examQuestionfiveMark, ...examQuestiontenMark];

    return (
        <div className='bg-dark bg-opacity-10 '>
            <TopNav />
            <div className='d-flex mt-5 vh-50  justify-content-center align-items-start '>
                <div className='w-75 mt-5 form-control'>
                    <div class="d-flex justify-content-between mt-2 ">
                         <h5 className='d-flex justify-content-Start align-items-start'> Date :________________ </h5>
                         <h5 className='d-flex justify-content-end'> Roll Number :________________ </h5> </div>
                    <div>  <h2 className=''>{examdetails.departname}</h2> </div> 
                    <div>  <h3 className=''>{examdetails.subjectname}</h3> </div>       
                    <div>  <h6 > {examdetails.examname} </h6> </div>

                    <div class="container ">
                        <div class="d-flex justify-content-around">                            
                            <div class=""> 
                                {examdetails.totalmark===100 && <h5> Duration: 3 Hours </h5>}
                                {examdetails.totalmark===50 && <h5 > Duration: 1 Hours 30 Minutes </h5>}
                                {examdetails.totalmark===20 && <h5 > Duration: 1 Hours </h5>}
                                {examdetails.totalmark===10 && <h5 > Duration: 40 Minutes </h5>}  
                            </div>
                            <div class="">
                                <h5> Regulation: 2023 </h5>
                            </div>
                            <div class="">
                                <h5> Max. Marks {examdetails.totalmark} </h5>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div className='d-flex justify-content-center'>
                <div className='w-75 form-control'>
                    { examQuestiononeMark.length > 0  && <h5>Answer All Questions 1 * {examQuestiononeMark.length} = {1*examQuestiononeMark.length} Mark </h5>  
                    }             
                    <table className="table">
                        <tbody className='table'>
                            {  
                                examQuestiononeMark.map((e, i) =>     
                               <tr key={e.examquestionid}>
                                    <td className="text-start">{i+1+')'}</td>
                                    <td className="text-start">{e.questiondescription}</td>
                                    <td className="text-end">{e.weightage}</td>
                                </tr>,
                                 
                                )}
                                
                        </tbody>
                    </table>
                    
                    { examQuestiontwoMark.length > 0  && <h5>Answer All Questions 2 * {examQuestiontwoMark.length} = {2*examQuestiontwoMark.length} Mark </h5>  }             
                    <table className="table">
                        <tbody className='table'>
                            {examQuestiontwoMark.map((e, i) =>
                               <tr key={e.examquestionid}>
                                    <td className="text-start">{i+examQuestiononeMark.length+1+')'}</td>
                                    <td className="text-start">{e.questiondescription}</td>
                                    <td className="text-end">{e.weightage}</td>
                                </tr>)}
                        </tbody>
                    </table>
                    { examQuestionfiveMark.length > 0 && (examdetails.isoptionalsupport==='N' || (examdetails.totalmark===20 || examdetails.totalmark===10 )) && <h5>Answer All Questions 5 * {examQuestionfiveMark.length} = {5*examQuestionfiveMark.length} Mark </h5>  }             
                    { examQuestionfiveMark.length > 0 && (examdetails.isoptionalsupport==='Y'&&  examdetails.totalmark===100 )  && <h5>Answer Any 6 Questions 5 * 6 = {5*6} Mark </h5>  }             
                    { examQuestionfiveMark.length > 0 && (examdetails.isoptionalsupport==='Y' && examdetails.totalmark===50 )  && <h5>Answer Any 3 Questions 5 * 3 = {5*3} Mark </h5>  }             
                    <table className="table">
                        <tbody className='table'>
                            {examQuestionfiveMark.map((e, i) =>
                               <tr key={e.examquestionid}>
                                    <td className="text-start">{i+examQuestiononeMark.length+examQuestiontwoMark.length+1+')'}</td>
                                    <td className="text-start">{e.questiondescription}</td>
                                    <td className="text-end">{e.weightage}</td>
                                </tr>)}
                        </tbody>
                    </table>
                    { examQuestiontenMark.length > 0 && (examdetails.isoptionalsupport==='N' ||(examdetails.totalmark===20 || examdetails.totalmark===10)) && <h5>Answer All Questions 10 * {examQuestiontenMark.length} = {10*examQuestiontenMark.length} Mark </h5>  }  
                    { examQuestiontenMark.length > 0 && examdetails.isoptionalsupport==='Y' && examdetails.totalmark===100  && <h5>Answer Any 4 Questions 10 * 4 = 40 Mark </h5>  }  
                    { examQuestiontenMark.length > 0 && examdetails.isoptionalsupport==='Y' && examdetails.totalmark===50  && <h5>Answer Any 2 Questions 10 * 2 = 20 Mark </h5>  }  
                    <table className="table bb-bg">
                        <tbody className='table bb-bg'>
                            {examQuestiontenMark.map((e, i) =>
                               <tr key={e.examquestionid}>
                                    <td className="text-start">{i+examQuestiononeMark.length+examQuestiontwoMark.length+examQuestionfiveMark.length+1+')'}</td>
                                    <td className="text-start">{e.questiondescription}</td>
                                    <td className="text-end">{e.weightage}</td>
                                </tr>)}
                        </tbody>
                    </table>
                    <p className="text-secondary"> ******************************** All the best ********************************</p>


                     

{/*                                
                            {     
                                combinedArray.map((e, i) => <tr key={e.examquestionid}>
                                    <td>{i + 1}</td>
                                    <td className="text-lg-start">{e.questiondescription}</td>
                                    <td className="text-lg-end  ">{e.weightage}</td>
                                    
                                </tr>    )
                            }  

 
                            <h4> Answer all one mark question</h4> 


                            {

                             
                                
                                examQuestiononeMark.map((e, i) => <tr key={e.examquestionid}>
                                    <td>{i + 1}</td>
                                    <td className="text-lg-start">{e.questiondescription}</td>
                                    <td className="text-lg-end  ">{e.weightage}</td>
                                </tr>
                                )
                            }


                                <h4> Answer all two mark question</h4>
                            {
                                
                                examQuestiontwoMark.map((e, i) => <tr key={e.examquestionid}>
                                    <td>{i + 1}</td>
                                    <td className="text-lg-start">{e.questiondescription}</td>
                                    <td className="text-lg-end  ">{e.weightage}</td>
                                </tr>
                                )
                            }

                                <h4> Answer all five mark question</h4>
                            {
                                
                                examQuestionfiveMark.map((e, i) => <tr key={e.examquestionid}>
                                    <td>{i + 1}</td>
                                    <td className="text-lg-start">{e.questiondescription}</td>
                                    <td className="text-lg-end  ">{e.weightage}</td>
                                </tr>
                                )
                            }

                            <h4> Answer all ten mark question</h4>
                            {examQuestiontenMark.map((e, i) => <tr key={e.examquestionid}>
                                <td>{i + 1}</td>
                                <td className="text-lg-start">{e.questiondescription}</td>
                                <td className="text-lg-end  ">{e.weightage}</td>
                            </tr>
                            )
                            }  
*/}
                        {/* </tbody>

                    </table> */}
                </div>


            </div>





        </div>
    )
}

export default QuestionPaperQuestionList
