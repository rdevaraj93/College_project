import React from 'react'
import DashboardTabnav from '../Dashboard/DashboardTabnav'
import QuestionList from './QuestionList'
import { Outlet, useNavigate } from "react-router-dom";
 

function QuestionOption() {
    
    const navigate = useNavigate();

    const addnewquestion = () => {
        console.log("CLick the user")
        navigate("/AddQuestion");
        
    }

    const showquestionlist = () => {
        console.log("CLick the user")
        navigate("/QuestionList");
        
        
    }
    
    
    return (
        <div>
            <div className="container-fluid bg-info border border-black">
                <h1 className="bg-info text-white fst-italic fw-bold">Question Paper Generator</h1>
            </div>
            <DashboardTabnav />


            <div className="row">
                <div className="col-sm-6">
                    <div className="card">
                        <div className="card-body">
                            <h5 className="card-title">Show Question List</h5>
                            <p className="card-text">With supporting Tool Teacher details can be modified or deleted.</p>
                            <a href="#" onClick={showquestionlist} className="btn btn-primary">Show Question List</a>
                        </div>
                    </div>
                </div>
                <div className="col-sm-6">
                    <div className="card">
                        <div className="card-body">
                            <h5 className="card-title">Add New Question</h5>
                            <p className="card-text">Use Below Button to give the access the new teacher</p>
                            <a href="#" onClick={addnewquestion} className="btn btn-primary">Add New Question</a>
                        </div>
                    </div>
                </div>
            </div>

            <Outlet/>
        </div>
       
    )
}

export default QuestionOption
