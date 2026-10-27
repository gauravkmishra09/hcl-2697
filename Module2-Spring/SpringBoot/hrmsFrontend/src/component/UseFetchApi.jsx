
import React, { useEffect } from "react";
import { useState } from "react";
function UseFetchApi() {
    const[serverData, setServerData] =React.useState([]);
    useEffect(() => {
        async function getData() {
            try{
                const serverData = await fetch("https://fakestoreapi.com/products");
                       const jsonData = await serverData.json();
                       console.log(jsonData);
                       setServerData(jsonData);
            }
            catch(e){
                console.log(e);

            }
        }
        getData();
    },[])
return (
    <div>UseFetchApi
    <h2>{
    JSON.stringify(serverData)
        }</h2>
    </div>
)
}
export default UseFetchApi
        