import React, { useState, useEffect } from 'react'
import { listAllExam } from '../../Services/QuestionPaperService'
import style from "../../style.module.css"

function ListAllExamComponent() {

  const [questionlist, setQuestionlist] = useState([])


  useEffect(() => {
    getallexamList();
  }, [])

  const getallexamList = () => {
    listAllExam().then((response) => {
      setQuestionlist(response.data)
      console.log(response.data);
    }).catch(error => {
      console.log(error);
    })
  }

  return (
    <div className="container ">
      <h1 className="text-center"> Exam List</h1>

      <table className="table table-striped border border-dark">
        <thead>
          <tr>
            <th scope="col" >Exam Name</th>
            <th scope="col">Department</th>
            <th scope="col">Total Mark</th>
            <th scope="col">Optional Question support</th>
          </tr>
        </thead>
        <tbody>
          {
            questionlist.map(e => <tr key={e.examid}>
              <td> <a href = {ListAllExamComponent}></a> {e.examname} </td>
              <td>{e.departname}</td>
              <td>{e.totalmark} </td>
              <td>{e.isoptionalsupport} </td>
            </tr>
            )
          }

        </tbody>
      </table>

    </div>
  )


}

export default ListAllExamComponent;