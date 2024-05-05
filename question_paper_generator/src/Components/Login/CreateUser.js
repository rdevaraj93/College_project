import axios from 'axios'
import React from 'react'
import { useState } from 'react'
import DashboardTabnav from '../Dashboard/DashboardTabnav';
import TopNav from '../Login/TopNav';
import { Outlet, useNavigate } from "react-router-dom";
function CreateUser() {
    const navigate = useNavigate();
    const [actionstatus, setactionstatus] = useState('');

    const [useradd, setUserAdd] = useState({
        vv_user_id: -1,
        vv_user_roll_id: '',
        vv_first_name: '',
        vv_last_name: '',
        vv_password: ''
    })


    const handleInput = (event) => {
        setUserAdd({ ...useradd, [event.target.name]: event.target.value })


    }

    function handleSubmit(event) {
        event.preventDefault();
        console.log({ useradd })
       


        axios.post('http://localhost:8080/user/adduser', useradd)
            .then(res => {
                console.log(res)
                // alert('Add User : ' + res.data.po_message )
                console.log("Calling ")
                existingUser(res.data.po_message)
                
               
            }
            )
            .catch(err => console.log(err))
    }

    function existingUser(message) {
        if (message === 'Existing User') {
            alert(' Existing User')
            //setactionstatus('User id is already preasent')
        } else {
            alert('Add User : ' + message)
            //  setactionstatus('User Added Successfully')
            
        }
        //window.location.reload(false);
        navigate("/userlistorupdate")
    }
     


    return (
        <div  >
             
            <nav className="fixed-top bg-primary bg-gradient bg-opacity-10" >
                <div className="container-fluid bg-info border border-black wh-20%">
                    <h1 className="bg-info text-white fst-italic fw-bold ">Question Paper Generator</h1>
                </div>
                <DashboardTabnav/>
            
            
        <div className='bg-primary bg-gradient bg-opacity-10'>
            <h3 className="">Add New User</h3>
            <div className='d-flex vh-100 justify-content-center align-item-center '>

                <div className='p-3 h-50 bg-white w-25 border border-dark-subtle border-3 rounded-4 '>
                    <form  className='' onSubmit={handleSubmit} >
                        <div className='mb-3' >
                            <label className='d-flex justify-content-start align-items-start' > User ID</label>
                            <input type="text" placeholder='Enter user ID' className='form-control' name="vv_user_roll_id"
                                onChange={handleInput} />
                        </div>
                        <div className='mb-3' >
                            <label  className='d-flex justify-content-start'> First Name</label>
                            <input type="text" placeholder='Enter First Name' className='form-control' name="vv_first_name"
                                onChange={handleInput} />
                        </div>

                        <div className='mb-3' >
                            <label  className='d-flex justify-content-start'> Last Name</label>
                            <input type="text" placeholder='Enter Last Name' className='form-control' name="vv_last_name"
                                onChange={handleInput} />
                        </div>

                        <div className='mb-3'>
                            <label className='d-flex justify-content-start'> Password</label>
                            <input type="password" placeholder='Enter Password' className='form-control' name="vv_password"
                                onChange={handleInput} />
                        </div>
                        <button className='btn btn-success'>Add User</button>
                    </form>
                </div>
            </div>
            </div>
            </nav>
            
        </div>
    )
}

export default CreateUser
