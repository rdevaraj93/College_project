import React, { useEffect, useRef } from 'react'
import TopNav from '../Login/TopNav'
import axios, { Axios } from 'axios'
import { useState } from 'react'
import { Navigate, Outlet, useNavigate } from 'react-router-dom';

function QuestionPaperCreate() {

    const navigate = useNavigate();

    const [depart, setDepart] = useState([])
    const [subjectlist, setSubjectlist] = useState([])
    const [unitlist, setUnitlist] = useState([])
    

    const [exambean, SetExambean] = useState({
        newQuestionpaperID: -1,
        examName: null,
        departmentID: null,
        subjectID: null,
        unitIDList: [],
        totalexammark: null,
        issuppotoptional: null
    })

    const [totalMarklist, setTotalMarklist] = useState([
        {
            lable: '10 Mark',
            value: 10

        },
        {
            lable: '20 Mark',
            value: 20
        },
        {
            lable: '50 Mark',
            value: 50

        },
        {
            lable: '100 Mark',
            value: 100
        }
    ])

    const [repeat, setRepeat] = useState(
        [
            {
                lable: 'Yes',
                value: 'Y'

            },
            {
                lable: 'No',
                value: 'N'
            }
        ]
    )

    useEffect(() => {

            
        //to get list departments

        axios.get('http://localhost:8080/department/getalldepartment')
            .then(res => {
                console.log(res.data)
                setDepart(res.data)
            })
            .catch(err => console.log(err))

        //to get subject name list
        axios.get('http://localhost:8080/question/getsubjectnamelist/')
            .then(res => {
                console.log(res.data)
                setSubjectlist(res.data)
            })
            .catch(err => console.log(err))


        //to get unit list
        axios.get('http://localhost:8080/question/getunitlist/')
            .then(res => {
                console.log(res.data)
                setUnitlist(res.data)
            })
            .catch(err => console.log(err))

    }, [])



    const handleCheckboxChange = (event) => {
        const { id, checked } = event.target;
        if (checked) {
            SetExambean({ ...exambean, unitIDList:[...exambean.unitIDList, id] })
            console.log('checked')
        } else {
            SetExambean({ ...exambean, unitIDList:[...exambean.unitIDList.filter((item) => item !== id)] })
            console.log('unchecked')
        }
       
    };


    const generatequestionpaper = (event) => {
        event.preventDefault();
        console.log(exambean)
        axios.post('http://localhost:8080/generate/newquestionpaper', exambean)
            .then(res => {
                console.log(res.data)
                navigate('/Questionpaperlist')
            })
            .catch(err => console.log(err))        
    }

 

    return (

        <div>
            <TopNav />
            <div className=' mt-5 p-5 vh-100  bg-primary bg-gradient bg-opacity-10'>
                <h2>Generate new exam Question paper</h2>

                <div className='d-flex vh-50  justify-content-center align-items-start '>
                    <div className='w-75 form-control'>
                        <form className='mx-auto' onSubmit={generatequestionpaper}>
                            <table class="table table-striped-columns p-2 ">
                                <tbody>
                                    <tr>
                                        <td className="d-flex align-items-start" >Exam Name</td>
                                        <td >
                                            <input onChange={e => SetExambean({ ...exambean, examName: e.target.value })} type="text" placeholder='Enter Exam Name' className='w-100 p-0 m-0' />
                                        </td>
                                    </tr>
                                    <tr >
                                        <td className="d-flex align-items-start">Demartment Name</td>
                                        <td className="w-75 pe-2 " >
                                            <select className='w-100 rounded-2 align-items-start' onChange={e => SetExambean({ ...exambean, departmentID: e.target.value })}>
                                                <option disabled defaultValue selected>Select Department Name</option>
                                                {depart.map(e => (
                                                    <option key={e.departmentID} value={e.departmentID}  >{e.departmentName}
                                                    </option>
                                                ))}
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td className="d-flex align-items-start">Subject Name</td>
                                        <td>
                                            <select className='w-100 rounded-2 align-items-start' onChange={e => SetExambean({ ...exambean, subjectID: e.target.value })}>
                                                <option disabled defaultValue selected>Select</option>
                                                {subjectlist.map(e => (
                                                    <option key={e.subjectidpk} value={e.subjectidpk}  >{e.subjectname}
                                                    </option>
                                                ))}
                                            </select>

                                        </td>
                                    </tr>
                                    <tr>
                                        <td className="d-flex align-items-start h-1 ">
                                            <td>
                                                Unit Name</td></td>
                                        <td>
                                            {/* <select multiple   className='w-100 rounded-2 align-items-start multiselect'  //onChange={handleSelectChange}   
                                            >
                                                <option   disabled defaultValue selected>Select</option>
                                                {unitlist.map(e => (
                                                    <option key={e.unitidpk} value={e.unitidpk}  >{e.unitname}
                                                    </option>
                                                ))}
                                            </select> */}

                                            {unitlist.map((checkbox) => (
                                                <td key={checkbox.unitidpk}>
                                                    <label>
                                                        <input
                                                            type="checkbox"
                                                            id={checkbox.unitidpk}
                                                            value={checkbox.unitidpk}
                                                            onChange={handleCheckboxChange}
                                                        />
                                                        {checkbox.unitname}
                                                    </label>
                                                </td>
                                            ))}

                                        </td>
                                    </tr>

                                    <tr>
                                        <td className="d-flex align-items-start">Mark</td>
                                        <td>
                                            <select className='w-100 rounded-2 align-items-start' onChange={e => SetExambean({ ...exambean, totalexammark: e.target.value })}>
                                                <option disabled defaultValue selected>Select</option>
                                                {totalMarklist.map(e => (
                                                    <option key={e.id} value={e.value}  >{e.lable}
                                                    </option>
                                                ))}
                                            </select>

                                        </td>
                                    </tr>
                                    <tr>
                                        <td className="d-flex align-items-start">Is support optional</td>
                                        <td>
                                            <select className='w-100 rounded-2 align-items-start' onChange={e => SetExambean({ ...exambean, issuppotoptional: e.target.value })}>
                                                <option disabled defaultValue selected>Select</option>
                                                {repeat.map(e => (
                                                    <option key={e.id} value={e.value}  >{e.lable}
                                                    </option>
                                                ))}

                                            </select>

                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            <button className='btn btn-success'>Generate</button>
                        </form>
                    </div>
                </div>

            </div>

        </div >
    )
}

export default QuestionPaperCreate
