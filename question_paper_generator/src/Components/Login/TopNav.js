import React from 'react'
import style from '../../style.module.css'
import { alignPropType } from 'react-bootstrap/esm/types'
import DashboardTabnav from '../Dashboard/DashboardTabnav'

export default function TopNav() {
    return (
        <div>
            {/* <nav class="fixed-top" >
                <div class="container-fluid bg-primary border border-black">
                    <h1 class="bg-primary text-white ">Question Paper Generator</h1>
                </div>
            </nav> */}
            
                <nav className="fixed-top" >
                    <div className="container-fluid bg-info border border-black">
                        <h1 className="bg-info text-white fst-italic fw-bold">Question Paper Generator</h1>
                    </div>
                    <DashboardTabnav />
                </nav>

           

        </div>


    )
}
