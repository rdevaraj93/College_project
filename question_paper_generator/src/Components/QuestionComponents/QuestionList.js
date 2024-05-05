import React, { useEffect, useState } from 'react'
import TopNav from '../Login/TopNav'
import axios from 'axios';
import { Button } from 'react-bootstrap';
import { Navigate, Outlet, useNavigate } from 'react-router-dom';
import styles from './Question.css';

function QuestionList() {

    const [questionList, setQuestionList] = useState([])
    const [delete_flag, setdelete_flag] = useState(false)
    const navigate = useNavigate();

    const [depart, setDepart] = useState([])

    const [addquestionlist1, SetAddquestionlist1] = useState({

        questionId: '',
        questionuniid : '',
        questionDescription: '',
        departId: '',
        subjectId: '',
        unitId: '',
        difficultyId: '',
        termId: 1,
        questWeightAgeId: '',
        isImportant: '',
        isRepeat: '',
        isValid: 'N',
        createUserId: 1,
        updatedUserId: 1
       
    })


   const getquestionlist  = () => {
        axios.get('http://localhost:8080/question/getallquestion/')
        .then(res => {
            //console.log(' get question list' + res.data);
            setQuestionList(res.data)

        })
   }

   

    useEffect(() => {
        getquestionlist();

        axios.get('http://localhost:8080/department/getalldepartment')
      .then(res => {
        console.log(res.data)
        setDepart(res.data)
      })
      .catch(err => console.log(err))


    },[]);


    const addquestion = () => {
       // console.log('Add question is triggered')
        navigate("/AddQuestion")
    }

    const questionDelete = (id) => {
        
        axios.get("http://localhost:8080/question/getquestionbyid/"+id)
     .then(res => {
      console.log('DELETE Data' + id)
      console.log(res.data)
      SetAddquestionlist1({...addquestionlist1,
        questionId:  id,
        questionuniid : res.data.questionuniid,
        questionDescription: res.data.questiondescription,
        departId:  res.data.departmentID,
        subjectId: res.data.subjectid,
        unitId:  res.data.unitid,
        difficultyId:  res.data.difficultyid,
        termId:  1,
        questWeightAgeId:  res.data.questionweightid,
        isImportant: res.data.isimportent,
        isRepeat: res.data.isrepeat,
        createUserId: res.data.createduserid,
        updatedUserId: res.data.createduserid

      })

      //console.log('AddData')
      //console.log(addquestionlist1)

      axios.post('http://localhost:8080/question/addquestion/',addquestionlist1)
      .then(res =>{
        console.log(res.data);
       // alert('Deleted Successfully')
       // getquestionlist();
        })
      .catch(err => console.log(err))
      
     })
         
    
    
    setdelete_flag(true);
   

    }


    const questionUpdate = (id) => {
        console.log(" question Update called number" + id);
        navigate(`/updateQuestion/${id}`)
    }

    const [selecteddepart, setSelecteddepart] = useState('0')
    const [fquestionList, setFQuestionList] = useState([])

    const getFquestionlist  = (event) => {
       setSelecteddepart(event.target.value)
        if(event.target.value !==0) {
            axios.get('http://localhost:8080/question/getallquestionbydeparmnt/'+ event.target.value)
            .then(res => {
            setFQuestionList(res.data)
            console.log('selected'  + event.target.value)
            })
        }
        else
        {
            console.log('selected non '  + event.target.value)
            getquestionlist();
        }
   }

    return (
        <div>
            <TopNav />
            
            <div className='mt-5 p-1 bg-primary bg-gradient bg-opacity-10'>
                <div className='mt-5'>
                    <div class="container-fluid ">
                        
                        <div className='rol'>
                            <h3 className="text-center"> Question List</h3>
                        </div>
                        
                        
                        <div className="d-flex align-items-start">
                            <button onClick={addquestion} className='btn btn-primary m-2' >Add Question</button>
                        </div>
                        <div className="d-flex align-items-start">
                        <select className='w-10 rounded-2 align-items-start' onChange={getFquestionlist}>
                                <option defaultValue selected value={'0'}>Select All/Filter</option>
                                {depart.map(e => (
                                <option key={e.departmentID} value={e.departmentID} >{e.departmentName}
                                </option>
                                ))}
                            </select>
                             
                            </div>
                           
                        <div className="table-responsive rounded form-control">
                            <table className="table table-fixed table-hover ">
                                <thead className="bg-warning.bg-gradient table-primary"  >
                                    <tr >
                                        <th scope="col">S.No</th>
                                        <th scope="col">Question Description</th>
                                        <th scope="col">ID</th>
                                        { selecteddepart==='0' &&
                                            <th scope="col">Department Name</th>
                                        }
                                        <th scope="col">Subject Name</th>
                                        <th scope="col">Unit Name</th>
                                        <th scope="col">Difficulty</th>
                                        <th scope="col">Mark</th>
                                        <th scope="col">Is Importent</th>
                                        <th scope="col">Is repeat</th>
                                        <th scope="col">Action</th>

                                    </tr>
                                </thead>
                                <tbody class="text-center">
                                    { selecteddepart === '0' &&
                                        questionList.map((e,i) => <tr key={e.questionid}>
                                            <td>{i+1+')'} </td>
                                            <td  class="text-start" >{e.questiondescription} </td>
                                            <td >{e.questionuniid} </td>
                                            <td>{e.departmentName} </td>
                                            <td>{e.subjectname} </td>
                                            <td>{e.unitname} </td>
                                            <td>{e.difficultydescription} </td>
                                            <td>{e.questionweightage} </td>
                                            <td>{e.isimportent} </td>
                                            <td>{e.isrepeat} </td>
                                            <td>
                                                <button onClick={() => questionDelete(e.questionid)} className='btn btn-success hover' >Delete</button>
                                                <button onClick={() => questionUpdate(e.questionid)} className='btn btn-success m-2' >Update</button>
                                            </td>

                                        </tr>
                                        )
                                    }
                                    { selecteddepart!==0 &&
                                        fquestionList.map((e,i) => <tr key={e.questionid}>
                                            <td>{i+1+')'} </td>
                                            <td  class="text-start" >{e.questiondescription} </td>
                                            <td >{e.questionuniid} </td>
                                            <td>{e.subjectname} </td>
                                            <td>{e.unitname} </td>
                                            <td>{e.difficultydescription} </td>
                                            <td>{e.questionweightage} </td>
                                            <td>{e.isimportent} </td>
                                            <td>{e.isrepeat} </td>
                                            <td>
                                                <button onClick={() => questionDelete(e.questionid)} className='btn btn-success hover' >Delete</button>
                                                <button onClick={() => questionUpdate(e.questionid)} className='btn btn-success m-2' >Update</button>
                                            </td>

                                        </tr>
                                        )
                                    }

                                </tbody>
                            </table>
                        </div>
                        {/**/}

                    </div>








                </div>
            </div>
        </div>
    )
}

export default QuestionList
