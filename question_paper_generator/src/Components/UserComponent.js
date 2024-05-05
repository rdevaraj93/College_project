import React, { useEffect, useState } from 'react'
import TestService from '../Services/TestService'

function UserComponent() {
  
    const [user,setUser] = useState([])
  
    useEffect(() => {
        getUsers()
      },[]);
    

    const getUsers = () => {
        TestService.getUser().then(
            (response) => {
                setUser(response.data);
                console.log(response.data);
            }

        );
    };

    return (
    <div className="container">
       <h1 className="text-center"> User List</h1>

       <table className="table table-striped">
  <thead>
    <tr>
      <th scope="col">userrollid</th>
      <th scope="col">userfirstname</th>
      <th scope="col">userlastname</th>
      <th scope="col">userdisplayname</th>
    </tr>
  </thead>
  <tbody>
    {
        user.map(e => <tr key={e.useridpk}> 
            <td>{e.userrollid} </td>
            <td>{e.userfirstname} </td>
            <td>{e.userlastname} </td>
            <td>{e.userdisplayname} </td>
        </tr> 
    )
    }
       
  </tbody>
</table>

    </div>
  )
}

export default UserComponent;