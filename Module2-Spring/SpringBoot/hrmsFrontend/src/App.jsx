import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './App.css'

import Home from './components/Home'
import Dashboard from './components/Dashboard'
import Login from './components/Login'
import Registration from './components/Registration'



function App() {
//   const employee=[
//   {  ename:"Rahul", empid:"120"},
//   {  ename:"sahul", empid:"121"},
//   {  ename:"menon", empid:"122"},
//   {  ename:"rakes", empid:"123"},
//   ]


  return (
    <>
    {/* <Navbar/>
      <h2>Welcome to HRMS</h2> */}
     {/* {
      employee.map(ele=>
        <h3>
        <SampleCode empdata={ele}/>
        <br />
        </h3>
      )
     } 
     <SampleCode/> 
      <UseFetchApi/> */}
      <BrowserRouter>
       <Routes>
         <Route path="/" element={<Home/>}/>
         <Route path="/login" element={<Login/>}/>
         <Route path="/register" element={<Registration/>}/>
         <Route path="/dashboard" element={<Dashboard/>}/>
       </Routes>
      </BrowserRouter>
    
    </>
  );
}


export default App