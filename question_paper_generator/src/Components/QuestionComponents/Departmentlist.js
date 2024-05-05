import axios from 'axios';
import React, { useLayoutEffect, useState } from 'react'
import { useEffect } from 'react'

function Departmentlist() {

  const [depart, setDepart] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/department/getalldepartment')
      .then(res => {
        setDepart(res.data)
        console.log(res.data)
      })
      .catch(err => console.log(err))
  }, []);



  return (
    <div>
      
    </div>
  )
}

export default Departmentlist
