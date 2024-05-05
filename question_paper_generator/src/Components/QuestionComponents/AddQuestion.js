import React, { useEffect } from 'react'
import TopNav from '../Login/TopNav'
import axios, { Axios } from 'axios'
import { useState } from 'react'
import { Navigate, Outlet, useNavigate } from 'react-router-dom';

function AddQuestion() {

  const navigate = useNavigate();

  const [depart, setDepart] = useState([])
  const [ques_Defficulty, setQues_Defficulty] = useState([])
  const [ques_marklist, setQues_marklist] = useState([])
  const [unitlist, setUnitlist] = useState([])
  const [subjectlist, setSubjectlist] = useState([])

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

  // const [depart, setDepart] = useState([])

  const [addquestionlist, SetAddquestionlist] = useState({

    questionId: -1,
    questionuniid : null,
    questionDescription: null,
    departId: null,
    subjectId: null,
    unitId: null,
    difficultyId: null,
    termId: 1,
    questWeightAgeId: null,
    isImportant: '',
    isRepeat: '',
    isValid: 'Y',
    createUserId: 1,
    updatedUserId: 1
  })


  useEffect(() => {
    
    //to get list departments

    axios.get('http://localhost:8080/department/getalldepartment')
      .then(res => {
        console.log(res.data)
        setDepart(res.data)
      })
      .catch(err => console.log(err))


    //to get question difficulty 
    axios.get('http://localhost:8080/question/getquestiondeficalty/')
      .then(res => {
        console.log(res.data)
        setQues_Defficulty(res.data)
      })
      .catch(err => console.log(err))


    //to get question difficulty 
    axios.get('http://localhost:8080/question/getquestionmarklist/')
      .then(res => {
        console.log(res.data)
        setQues_marklist(res.data)
      })
      .catch(err => console.log(err))

    //to get unit list
    axios.get('http://localhost:8080/question/getunitlist/')
      .then(res => {
        console.log(res.data)
        setUnitlist(res.data)
      })
      .catch(err => console.log(err))

    //to get subject name list
    axios.get('http://localhost:8080/question/getsubjectnamelist/')
      .then(res => {
        console.log(res.data)
        setSubjectlist(res.data)
      })
      .catch(err => console.log(err))


  })
  //{/* <h1>{addquestionlist.departId}</h1> */}


  const handlesubmit = (event) => {
          event.preventDefault();
          console.log('clicked Add ')
          console.log({ addquestionlist })
          axios.post('http://localhost:8080/question/addquestion/',addquestionlist)
          .then(res => {console.log(res.data);
            alert('Question added success fully');
            Navigate('./QuestionList');
          }
          )
          .catch(err => console.log(err))
          window.location.reload(false);
         

  }

  return (

    <div>
      <TopNav />
      <div className=' mt-5 p-5 vh-100  bg-primary bg-gradient bg-opacity-10 '>
      <div className=''>
        <h2>Add Question</h2>

        <div className='d-flex vh-100  justify-content-center align-items-start'>

          <div className='w-75 p-3 form-control  '>
            <form  onSubmit={handlesubmit}>
              <table class="table table-striped-columns p-2 ">
                <tbody>
                  <tr >
                    <td className="d-flex align-items-start">Demartment Name</td>
                    <td className="w-75 pe-2 " >
                      <select className='w-100 rounded-2 align-items-start' onChange={e => SetAddquestionlist({ ...addquestionlist, departId: e.target.value })}>
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
                      <select className='w-100 rounded-2 align-items-start' onChange={e => SetAddquestionlist({ ...addquestionlist, subjectId: e.target.value })}>
                        <option disabled defaultValue selected>Select</option>
                        {subjectlist.map(e => (
                          <option key={e.subjectidpk} value={e.subjectidpk}  >{e.subjectname}
                          </option>
                        ))}
                      </select>

                    </td>
                  </tr>
                  <tr>
                    <td className="d-flex align-items-start">Unit Name</td>
                    <td>
                      <select className='w-100 rounded-2 align-items-start' onChange={e => SetAddquestionlist({ ...addquestionlist, unitId: e.target.value })}>
                        <option disabled defaultValue selected>Select</option>
                        {unitlist.map(e => (
                          <option key={e.unitidpk} value={e.unitidpk}  >{e.unitname}
                          </option>
                        ))}
                      </select>

                    </td>
                  </tr>
                  <tr>
                    <td className="d-flex align-items-start" >Question ID</td>
                    <td>
                      <input onChange={e => SetAddquestionlist({...addquestionlist, questionuniid:e.target.value})} type="text" placeholder='Enter Question ID' className='w-100 p-0 m-0' />
                    </td>
                  </tr>
                  <tr>
                    <td className="d-flex align-items-start">Question Description</td>
                    <td>
                      <input onChange={e => SetAddquestionlist({...addquestionlist,questionDescription:e.target.value})} type="text" placeholder='Enter Question Description' className='w-100 p-0 m-0' />
                    </td>
                  </tr>
                  <tr>
                    <td className="d-flex align-items-start">Mark</td>
                    <td>
                      <select className='w-100 rounded-2 align-items-start' onChange={e => SetAddquestionlist({ ...addquestionlist, questWeightAgeId: e.target.value })}>
                        <option disabled defaultValue selected>Select</option>
                        {ques_marklist.map(e => (
                          <option key={e.questionmarkid} value={e.questionmarkid}  >{e.questionmarkweight}
                          </option>
                        ))}
                      </select>

                    </td>
                  </tr>
                  <tr>
                    <td className="d-flex align-items-start">Difficulty Level</td>
                    <td>
                      <select className='w-100 rounded-2 align-items-start' onChange={e => SetAddquestionlist({ ...addquestionlist, difficultyId: e.target.value })}>
                        <option disabled defaultValue selected>Select</option>
                        {ques_Defficulty.map(e => (
                          <option key={e.difficultyidpk} value={e.difficultyidpk}  >{e.difficultydescription}
                          </option>
                        ))}
                      </select>

                    </td>
                  </tr>
                  <tr>
                    <td className="d-flex align-items-start">Is important</td>
                    <td className="w-75 pe-2 " >
                      <select className='w-100 rounded-1 align-items-start' onChange={e => SetAddquestionlist({ ...addquestionlist, isImportant: e.target.value })}>
                        <option disabled defaultValue selected>Select</option>
                        {repeat.map(e => (
                          <option key={e.id} value={e.value}  >{e.lable}
                          </option>
                        ))}
                      </select>
                    </td>
                  </tr>
                  <tr>
                    <td className="d-flex align-items-start">Is repeat </td>
                    <td className="w-75 pe-2 " >
                      <select className='w-100 rounded-1 align-items-start' onChange={e => SetAddquestionlist({ ...addquestionlist, isRepeat: e.target.value })}>
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
              <button className='btn btn-success'>Add</button>
            </form>
          </div>
        </div>
        </div>





      </div>
    </div >
  )
}

export default AddQuestion;
