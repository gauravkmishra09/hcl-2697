import React from 'react'
import { Link } from 'react-router-dom'

function Navbar() {
  return (
    <>
     <nav>
      <Link to="/">Home</Link>
      <Link to="/addEmployee">Add Employee</Link>
      <Link to="/removeEmployee">Remove Employee</Link>
      <Link to="/findById">Find Employee</Link>
     </nav>
    </>
  )
}

export default Navbar