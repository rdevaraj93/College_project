import React, { useEffect } from 'react'
import TopNav from '../Login/TopNav'
import axios, { Axios } from 'axios'
import { useState } from 'react'
import { Navigate, Outlet, useNavigate, useParams } from 'react-router-dom';
import DashboardTabnav from '../Dashboard/DashboardTabnav'
import Questionpaperlist from '../QuestionPaperComponent/QuestionPaperList'

function QuestionPaperOption() {

    const navigate = useNavigate();

    const createnewquestionpaper = () => {
        console.log("CLick the user")
        navigate('/Questionpapercreate')
        
    }

    const Showquestionpaperlist = () => {
        console.log("CLick the user")
        navigate('/Questionpaperlist')
        
        
    }
    
    
    return (
        <div>
            <div className="container-fluid bg-primary border border-black">
                <h1 className="bg-primary text-white ">Question Paper Generator</h1>
            </div>
            <DashboardTabnav />


            <div className="row">
                <div className="col-sm-6">
                    <div className="card">
                        <div className="card-body">
                            <h5 className="card-title">Show Question Paper List</h5>
                            <p className="card-text">With supporting Tool Teacher details can be modified or deleted.</p>
                            <a onClick={Showquestionpaperlist}  className="btn btn-primary">Show Question Paper List</a>
                        </div>
                    </div>
                </div>
                <div className="col-sm-6">
                    <div className="card">
                        <div className="card-body">
                            <h5 className="card-title">Generate New Question Paper</h5>
                            <p className="card-text">Use Below Button to Generate new exam question paper</p>
                            <a onClick={createnewquestionpaper}  className="btn btn-primary">Generate Question Paper</a>
                        </div>
                    </div>
                </div>
            </div>

            <Outlet/>
        </div>
       
    )
}

export default QuestionPaperOption;

 
