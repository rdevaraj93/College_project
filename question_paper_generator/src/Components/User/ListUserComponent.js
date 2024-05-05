import React, { useState, useEffect } from 'react'
import { listUsers } from '../../Services/UserService'
import axios from 'axios';
import UserUpdateComponent, { getUsersByID } from '../User/UserUpdateComponent';
import DashboardTabnav from '../Dashboard/DashboardTabnav';
import { Navigate, Outlet, useNavigate } from 'react-router-dom';

function ListEmployeeComponent() {

  const [users, setUsers] = useState([])
  
  const navigate = useNavigate();

  useEffect(() => {
    getAllUsers();
  }, [])

  const getAllUsers = () => {
    listUsers().then((response) => {
      setUsers(response.data)
      console.log(response.data);
    }).catch(error => {
      console.log(error);
    })
  }

  const [isaccess,setIsaccess] = useState(0)
  /*
  user delete


  */
  const userDelete = (message) => {
    console.log("delete number" + message)
    axios.delete('http://localhost:8080/user/deleteuser/' + message)
    .then(res =>
       {console.log(res)
        
        if(res.data.po_message === 'User have access') {
          setIsaccess(1)
         
        } 
        
      })
    .catch(err => console.log(err))

    if(isaccess === 1) {
      alert('user has department access')
        window.location.reload(false);
    }else {
      window.location.reload(false);
    }
    
  }

  const userUpdate = (id) => {
    console.log("Update called number" + id);
    
      navigate(`/userupdate/${id}`)
      console.log(`/userupdate/${id}`);

  }

  
    
   


  return (
    <>
      <nav className="fixed-top vh-100 bg-primary bg-gradient bg-opacity-10" >
        <div className="container-fluid bg-primary border border-black">
          <h1 className="bg-primary text-white ">Question Paper Generator</h1>
        </div>
        <DashboardTabnav />
        
        <div className="container ">
          <h1 className="text-center"> Teacher List</h1>

          <table className="table table-striped border border-dark">
            <thead className="bg-warning.bg-gradient" >
              <tr >
                <th scope="col">User Id</th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Display Name</th>
                <th scope="col">Action</th>
              </tr>
            </thead>
            <tbody>
              {
                users.map(e => <tr key={e.useridpk}>
                  <td>{e.userrollid} </td>
                  <td>{e.userfirstname} </td>
                  <td>{e.userlastname} </td>
                  <td>{e.userdisplayname} </td>
                  <td>
                    <button onClick={() => userDelete(e.useridpk)} className='btn btn-success' >Delete</button>
                    <button onClick={() => userUpdate(e.useridpk)} className='btn btn-success m-2' >Update</button>
                  </td>

                </tr>
                )
              }

            </tbody>
          </table>

        </div> 
      
       

        
      </nav>
      
      
    </>
  )


}

export default ListEmployeeComponent;