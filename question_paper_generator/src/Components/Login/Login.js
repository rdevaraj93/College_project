import TopNav from './TopNav'
import ProjectTittle from './ProjectTittle'
import LoginForm from './LoginForm';
import loginim from '../../image/login.png'
import homeim from "../../image/home.jpg"
import './Login.css';

export default function Login() {

    return (
        <div >

         
            <ProjectTittle></ProjectTittle>
            <LoginForm></LoginForm>
            <img class="fixed-bottom bb-bg" src={homeim} alt="logo" />  


        </div>
    )
}
