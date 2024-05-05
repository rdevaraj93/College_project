import React from 'react'
import { Outlet, useNavigate } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.css';
import ListEmployeeComponent from '../User/ListUserComponent'
import '../Login/Login.css'
function DashboardTabnav() {

    

    const navigate = useNavigate();

    const userpage = () => {
        console.log("CLick the user")
        navigate("/userpageoption");
        
    }

    const QuestionOption = () => {
        console.log("CLick the user")
        navigate("/QuestionOption");
        
    }

    const QuestionPaperGen = () => {
        console.log("Question Paper generate is clicked")
        navigate("/QuestionpaperOption");
        
    }

    const home = () => {
        navigate("/dashboard");
    }

    const Logout = () => {
        navigate("/");
    }



    return (
        <div> 
            <nav className="nav border mx-auto">
                <a className="nav-link text-dark" type="button" onClick={home} aria-current="page" href="#">Home</a>
                <a className="nav-link text-dark" type="button" onClick={userpage} aria-current="page" href="#">Teacher</a> 
                <a className="nav-link text-dark" type="button" onClick={QuestionOption} aria-current="page" href="#">Question</a>
                <a className="nav-link text-dark" type="button" onClick={QuestionPaperGen} aria-current="page" href="#">Generate Question paper</a>  
                <a className="ms-auto p-2 text-dark" type="button" onClick={Logout} aria-current="page" href="#">Logout</a>
            </nav>
          
        </div>
    )
}

export default DashboardTabnav
