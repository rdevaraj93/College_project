import './App.css';
import Login from './Components/Login/Login'
import { Routes, Route , BrowserRouter, Outlet} from 'react-router-dom';
import CreateUser from './Components/Login/CreateUser'
import DashBoard from './Components/Dashboard/DashBoard'
import UserpageOption from './Components/User/UserpageOption';
import UserUpdateComponent from './Components/User/UserUpdateComponent'
import ListEmployeeComponent from './Components/User/ListUserComponent'
import Test from './Components/TestC/Test';
import QuestionOption from './Components/QuestionComponents/QuestionOption';
import AddQuestion from './Components/QuestionComponents/AddQuestion';
import UpdateQuestion from './Components/QuestionComponents/UpdateQuestion';
import QuestionList from './Components/QuestionComponents/QuestionList';
import QuestionPaperOption from './Components/QuestionPaperComponent/QuestionPaperOption';
import QuestionPaperList from './Components/QuestionPaperComponent/QuestionPaperList';  
import QuestionPaperCreate from './Components/QuestionPaperComponent/QuestionPaperCreate'
import QuestionPaperQuestionList from './Components/QuestionPaperComponent/QuestionPaperQuestionList'

function App() {
  return (
    <div className="App">

       <BrowserRouter>
        <Routes>
                <Route path="/" element={<Login/>} />
                <Route path="/createuser" element={<CreateUser/>} />
                <Route path="/dashboard" element={<DashBoard/>} />
                <Route path="/userpageoption" element={<UserpageOption/>} />
                <Route path="/userlistorupdate" element={<ListEmployeeComponent/>} />
                <Route path="/userupdate/:id" element={<UserUpdateComponent/>} />
                <Route path="/QuestionOption" element={<QuestionOption />} />
                <Route path="/QuestionList" element={<QuestionList />} />
                <Route path="/AddQuestion" element={<AddQuestion />} />
                <Route path="/updateQuestion/:id" element={<UpdateQuestion/>} />
                <Route path="/QuestionpaperOption" element={<QuestionPaperOption/>} />
                <Route path="/Questionpaperlist" element={<QuestionPaperList/>} />
                <Route path="/Questionpapercreate" element={<QuestionPaperCreate/>} />
                <Route path="/QuestionpaperQuestionList/:id" element={<QuestionPaperQuestionList/>} />
                <Route path="/test" element={<Test/>} />

          </Routes>
        </BrowserRouter>
         
    </div>
    
    
   
  );
}

export default App;
