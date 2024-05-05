import React from 'react'
import DashboardTabnav from '../Dashboard/DashboardTabnav'
import { Outlet, useNavigate } from "react-router-dom";
 

function UserpageOption() {
    
    const navigate = useNavigate();

    const usercreate = () => {
        //console.log("CLick the user")
        navigate("/createuser");
        
    }

    const userlistorupdate = () => {
       // console.log("CLick the user")
        navigate("/userlistorupdate");
        
        
    }
    
    
    return (
        <div >
            <div className="container-fluid bg-primary border border-black">
                <h1 className="bg-primary text-white ">Question Paper Generator</h1>
            </div>
            <DashboardTabnav  />

            <div className="row">
                <div className="col-sm-6">
                    <div className="card">
                        <div className="card-body">
                            <h5 className="card-title">Active User List</h5>
                            <p className="card-text">With supporting Tool Teacher details can be modified or deleted.</p>
                            <a href="#" onClick={userlistorupdate} className="btn btn-primary">Show Existing Teacher</a>
                        </div>
                    </div>
                </div>
                <div className="col-sm-6">
                    <div className="card">
                        <div className="card-body">
                            <h5 className="card-title">Add New Teacher</h5>
                            <p className="card-text">Use Below Button to give the access the new teacher</p>
                            <a href="#" onClick={usercreate} className="btn btn-primary">Add New Teacher</a>
                        </div>
                    </div>
                </div>
            </div>

            <Outlet/>
        </div>
       
    )
}

export default UserpageOption
