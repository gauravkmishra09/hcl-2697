import React, { useState } from 'react'
import 'bootstrap/dist/css/bootstrap.min.css'
function Login() {
  const [emp_id, setEmpId] = useState('')
  const [password, setPassword] = useState('')
  const [email, setEmail] = useState('')

  async function loginform(e) {
    try {
      e.preventDefault();
      const server = await fetch("http://localhost:8080/v1/user/login", {
        method: 'Post',
        body: JSON.stringify({ emp_id: Number(emp_id), email, password}),
        headers: { "Content-Type": "application/json" }
      });
      const status = await server.text();
      alert(status)
      // if(server.ok()){
      //   <h1>Login Success</h1>
      // }
      // else{
      //    <h1>Unsuccess</h1>
      // }
    }
    catch (error) {
      console.log(error);
    }
  }

  return (
    <>
      Login Form
      <div>
        <form onSubmit={loginform}>
        <div className="form-group">
          <label htmlFor="emp_id">Emp ID</label>
          <input type="number" onChange={(e) => setEmpId(e.target.value)} className="form-control" id="emp_id" placeholder="Enter emp id" required />
        </div>
          <div className="form-group">
            <label htmlFor="email">Email</label>
            <input type="email" onChange={(e) => setEmail(e.target.value)} className="form-control" id="email" placeholder="Enter email" required />
          </div>

          <div className="form-group">
            <label htmlFor="password">Password</label>
            <input type="password" onChange={(e) => setPassword(e.target.value)} className="form-control" id="designation" placeholder="Enter Password" required />
          </div>
          <button type="submit" className="btn btn-primary">submit</button>

        </form>
      </div>
    </>
  )
}

export default Login