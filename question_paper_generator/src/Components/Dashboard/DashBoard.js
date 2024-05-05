import React from 'react'
import ProjectTittle from '../Login/ProjectTittle'
import { Outlet, useNavigate } from "react-router-dom";
import DashboardTabnav from './DashboardTabnav';
import homeim from "../../image/home.jpg"


function DashBoard() {

  const navigate = useNavigate();



  return (
    <>
      <div>
        <nav className="fixed-top bg-primary bg-gradient bg-opacity-10" >
          <div className="container-fluid bg-info border border-black">
            <h1 className="bg-info text-white fst-italic fw-bold ">Question Paper Generator</h1>
          </div>
          <DashboardTabnav />
          <div className='border'>

            <img class="rounded mx-auto d-block" src={homeim} alt="logo" />
            
          </div>

          <div className='d-flex w-100 justify-content-center  align-items-center '>
            <p className='fs-5 align-items-center' > <strong>Question Paper Generator </strong>  System is an innovative software simplifies exam paper creation. With this Paper Generator Software, schools, colleges, institutes and universities can easily create customized tests and exam question papers tailored to their curriculum and requirements. In addition, the Exam Management System helps streamline the entire exam management process, from creating the paper to grading and analysis. </p>

          </div>
          




        </nav>

      </div>
      <Outlet />
    </>
  )
}

export default DashBoard


