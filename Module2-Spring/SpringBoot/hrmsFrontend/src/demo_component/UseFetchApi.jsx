import React, { useEffect, useState } from 'react'

function UseFetchApi() {
    const[serverData, setServerData]=useState([]);

    useEffect(()=>{
       async function getData(){

            try{
            // const serverData = await fetch("https://fakestoreapi.com/products");
            const serverData = await fetch("http://localhost:8080/");
            const jsonData=await serverData.text();
            console.log(jsonData);
            setServerData(jsonData);
            }
            catch(e){
                console.log(e);
                <h1>Not found</h1>
            }
        }
        getData();
    },[])

  return (
    <div>
        {
           JSON.stringify(serverData)
        }
    </div>
  )
}

export default UseFetchApi