import { useEffect } from 'react'
import React, { useState } from 'react'

function SampleCode({empdata}) {
  const[counter, setCount] = useState(20);
  const[pointer, setPointer] = useState(100);

  useEffect(() => {
   
    console.log("counter value:"+counter);
    console.log("pointer value:"+pointer);

  },[ pointer]);
  function changeCounter() {
    setCount(counter + 2);
    
  }
  function changePointer() {
    setPointer(pointer-2);
  }
  return (
    <div>

<h2>Counter Value = {counter}</h2>
<h2>Pointer Value = {pointer}</h2>
<button onClick = {changeCounter}>Counter
</button>
<button onClick = {changePointer}>Pointer
</button>


 </div>

    
  )
}

export default SampleCode