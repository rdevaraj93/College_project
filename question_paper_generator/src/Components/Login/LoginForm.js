import React, { useState } from 'react'
import 'bootstrap/dist/css/bootstrap.min.css'
import axios from 'axios';
import { useEffect } from 'react';
import CreateUser from './CreateUser';
import { Outlet, useNavigate } from "react-router-dom";
import './Login.css';

function LoginForm() {

    const navigate = useNavigate();

    const [post1, setpost1] = useState({
        username: '',
        password: ''
    })


    const [successFlag, setSuccessFlag] = useState();

    const handleInput = (event) => {
        setpost1({ ...post1, [event.target.name]: event.target.value })
    }

    function handleSubmit(event) {
        event.preventDefault();
        console.log({ post1 })

        axios.post('http://localhost:8080/user/userlogin/', post1)
            .then(res => {
                console.log(res.data.po_message)
                //alert('Login was ' + res.data.po_message)
                setSuccessFlag(res.data.po_success_flag)
                if (res.data.po_success_flag === 1) {
                    setSuccessFlag(res.data.po_success_flag)
                    navigate("/dashboard");
                }
                else
                {
                    setSuccessFlag(res.data.po_success_flag)
                    console.log(res.data.po_message + successFlag)
                }

               // window.location.reload(true);

            }
            )
            .catch(err => console.log(err))
            
    }


    return (

        <div>
           <marquee behavior="scroll" direction="left" width="80%" > <h4 className='text-danger'>"Elevate Education with Ease: Empower your teaching journey with our Question Paper Software – simplifying preparation, enhancing assessment, and ushering in a new era of educational excellence."</h4> </marquee>
            <div className='d-flex w-100  position-absolute top-50 translate-middle-y justify-content-end ' >
                
               <div className='fw-bold text-info '>
                   
                    <div className='position-static top-50 start-0 translate-middle '>
                         <h1 className='fs-1 fw-bolder shadow-lg'>Save Your Time</h1>
                         <h4>To Generate Question Paper</h4>
                         <h3 className='fst-italic'>Via Question Papar Generate Software</h3>
                    </div>
                </div> 

                <div className='mt-2 me-5 p-3 bg-info w-25 rounded-3 shadow-lg'>

                    <div className="p-3  border rounded-3 border-opacity-50 bb-bg">
                        
                        <marquee> {successFlag === 0 && <h3 className='text-white'>User Name and Password is incorrect</h3>}</marquee>
                        
                        <form onSubmit={handleSubmit}   >
                            <h3>Login</h3>
                            <div className='mb-3'>
                               
                                <input type="text" placeholder='Enter user ID' className='form-control' name="username"
                                    onChange={handleInput} />
                            </div>

                            <div className='mb-3'>
                                <input type="password" placeholder='Enter Password' className='form-control' name="password"  onChange={handleInput} />
                            </div>
                            <button className='btn-success'>Login</button>
                        </form>
                    </div>
                </div>
            </div>
            
            

        </div>
    )
}

export default LoginForm