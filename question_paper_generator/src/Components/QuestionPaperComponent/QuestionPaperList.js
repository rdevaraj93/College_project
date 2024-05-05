import React, { useEffect, useState } from 'react'
import TopNav from '../Login/TopNav'
import axios from 'axios';
import { Button } from 'react-bootstrap';
import { Navigate, Outlet, useNavigate } from 'react-router-dom';
import icon from '../../image/delete.jpg'
import { Table, Pagination } from 'react-bootstrap';

function QuestionPaperList() {

const Navigate = useNavigate();

const [examlist, setExamlist] = useState([])



const [currentPage, setCurrentPage] = useState(1);
const [totalPages, setTotalPages] = useState(1);
const itemsPerPage = 10;  


const deleteQuestionpaper = (examid) => {
    console.log('delte was clicked ' + examid );
    axios.delete('http://localhost:8080/generate/questiondelete/'+examid)
    .then(res => console.log(res))
    .catch(err => console.log(err))
    window.location.reload(false);

}

const getquestionlist = (event) =>{
    const {id} = event.target;
    console.log("clicked the question exam list "  + id )
    Navigate(`/QuestionpaperQuestionList/${id}`)
}


const createnewquestion = () => {
    console.log('create new exam paper')
    Navigate('/Questionpapercreate')
}

  useEffect(() => {
    getallexamList();
  }, [])

  const getallexamList = () => {
    axios.get('http://localhost:8080/generate/getallexamList')
    .then(res => {
            console.log('to get all examlist')
            console.log(res.data)
            setExamlist(res.data)

    }).catch(err => console.log(err))
  }
    
    return (
        <div>
            <TopNav />
            <div className='mt-5 p-1 form-control vh-75 bg-primary bg-gradient bg-opacity-10'>
                <div className='mt-5'>
                    <div class="container-fluid ">
                        <div className='col'>
                            <h3 className="text-center"> Exam Question List</h3>
                        </div>
                        <div className="d-flex align-items-start">
                            <button onClick={createnewquestion} className='btn btn-primary m-2' >Create New Question paper</button>
                        </div>

                    </div>
                </div>

            </div>
            <input className='d-flex m-2 p-1' width="60%"  type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name"></input>
            <div className='form-control fixed-scroll-element '>
                <table class="table vh-50 table-hover table table-bordered">
                    <thead className="bg-warning.bg-gradient table-primary " >
                        <tr>
                        
                            <th scope="col">ID</th>
                            <th scope="col">Exam Name</th>
                            <th scope="col">Subject Name</th>
                            <th scope="col">Department</th>
                            <th scope="col">Total Mark</th>
                            <th scope="col">Optional Question support</th>
                            <th scope="col">Action</th>
                            
                            
                        </tr>
                    </thead>
                    <tbody>
                        {
                            examlist.map((e,i) => <tr key={e.examid}>

                                <td>{i+1}</td>
                                <td > 
                                    <a onClick={getquestionlist} id={e.examid} className="d-flex p-1 align-middle" href='#'>{e.examname} </a>
                                </td>
                                <td>{e.subjectname}</td>
                                <td>{e.departname}</td>
                                <td>{e.totalmark} </td>
                                <td>{e.isoptionalsupport} </td>
                                <td><button onClick={()=> deleteQuestionpaper(e.examid)} className='btn btn-success hover' >Delete</button></td>                                      
                            </tr>
                            )
                        }

                    </tbody>
                </table>
                
            </div>
        </div>
    )
}

export default QuestionPaperList
