import React, { useEffect } from 'react'
import axios from 'axios';
import { useState } from 'react';
import DashboardTabnav from '../Dashboard/DashboardTabnav';
import { Navigate, useParams, useNavigate } from 'react-router-dom';

function UserUpdateComponent() {

    const Navigate = useNavigate();
    const { id } = useParams();

    const [userUpdate, setUserUpdate] = useState({
        vv_user_id: id,
        vv_user_roll_id: '',
        vv_first_name: '',
        vv_last_name: '',
        vv_password: ''
    })
  
    useEffect(() => {
        getUsersByID( { id });
      }, [])


    function getUsersByID(props){
        console.log('update called')
        axios.post('http://localhost:8080/user/getuser/userid/'+props.id)
        .then(res => 
        {
            //console.log(res.data) 
            setUserUpdate({...userUpdate, 
                vv_user_id:res.data.useridpk,
                vv_user_roll_id:res.data.userrollid,
                vv_first_name:res.data.userfirstname,
                vv_last_name:res.data.userlastname,
                vv_password:res.data.userpassword

                 
            })
          
        })
        .catch(err => console.log(err))  
        //console.log('After'+ {userUpdate}) 
    }


    function handleSubmit(event) {
        event.preventDefault();
        console.log('--------------->' + {userUpdate})
        axios.post('http://localhost:8080/user/adduser', userUpdate)
            .then(res => {
               // console.log(res);
               Navigate('/userlistorupdate')
            }
            )
            .catch(err => console.log(err))
           
    } 
    

    return (
        <div>

            <nav className="fixed-top" >
                <div className="container-fluid bg-primary border border-black">
                    <h1 className="bg-primary text-white ">Question Paper Generator</h1>
                </div>
                <DashboardTabnav />
            </nav>
            <div className='mt-5 p-1'>
                <div className='mt-5 class="container text-center"'>
                    <div className="container-fluid "></div>

                    <h3>Update User Details</h3>
                    <div className='d-flex vh-100 justify-content-center align-item-center'>

                        <div className='p-3 bg-white w-25'>
                            <form  onSubmit={handleSubmit}>
                                <div className='mb-3' >
                                    <label  > User ID</label>
                                    <input type="text" placeholder='Enter user ID' className='form-control'
                                    value={userUpdate.vv_user_roll_id} disabled
                                    />
                                </div>
                                <div className='mb-3' >
                                    <label  > First Name</label>
                                    <input type="text" placeholder='Enter First Name' className='form-control'
                                    value={userUpdate.vv_first_name}
                                    onChange={ e => setUserUpdate({...userUpdate, vv_first_name: e.target.value })}
                                    />
                                </div>

                                <div className='mb-3' >
                                    <label  > Last Name</label>
                                    <input type="text" placeholder='Enter Last Name' className='form-control'
                                    value={userUpdate.vv_last_name}
                                    onChange={ e => setUserUpdate({...userUpdate, vv_last_name: e.target.value })}
                                    />
                                </div>

                                <div className='mb-3'>
                                    <label > Password</label>
                                    <input type="password" placeholder='Enter Password' className='form-control'
                                    value={userUpdate.vv_password}  
                                    onChange={ e => setUserUpdate({...userUpdate, vv_password: e.target.value })}   
                                    />
                                </div>
                                <button className='btn btn-success'>Update User</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    )
}

export default UserUpdateComponent;
