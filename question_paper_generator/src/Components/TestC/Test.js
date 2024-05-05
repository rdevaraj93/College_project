import React, { useEffect, useState } from 'react'
import ListEmployeeComponent from '../User/ListUserComponent';
import UserUpdateComponent from '../User/UserUpdateComponent';
import axios, { Axios } from 'axios'

function Test() {
  
 
  const [unitlist, setUnitlist] = useState([])

  useEffect(() => {
 
    //to get unit list
    axios.get('http://localhost:8080/question/getunitlist/')
        .then(res => {
            console.log(res.data)
            setUnitlist(res.data)
        })
        .catch(err => console.log(err))

        console.log(selectedCheckboxIds)


},[2])

const [selectedCheckboxIds, setSelectedCheckboxIds] = useState([]);

// Function to handle checkbox changes
const handleCheckboxChange = (event) => {
  const { id, checked } = event.target;
  
  // If the checkbox is checked, add the ID to the array, otherwise, remove it
  if (checked) {
    setSelectedCheckboxIds((prevIds) => [...prevIds, event.target.value]);
    console.log('checked')
  } else {
    setSelectedCheckboxIds((prevIds) => prevIds.filter((checkboxId) => checkboxId !==  event.target.value));
    console.log('unchecked')
  }
 
};


 

return (
  <div>
    <h2>Dynamic Checkboxes</h2>

    {selectedCheckboxIds}


    {unitlist.map((checkbox) => (
      <div key={checkbox.unitidpk}>
        <label>
          <input
            type="checkbox"
            id={checkbox.unitidpk}
            value={checkbox.unitidpk}
            onChange={handleCheckboxChange}
          />
          {checkbox.unitname}
        </label>
      </div>
    ))}
    <p>Selected checkbox IDs: {selectedCheckboxIds.join(', ')}</p>
  </div>
);
}

export default Test;
