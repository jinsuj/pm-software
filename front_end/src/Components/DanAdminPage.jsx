
import React, { useState } from 'react';
import Axios from 'axios';



const DanAdminPage = () => {
    const [username, setUsername] = useState('');
    const register = () => {
        Axios.post('http://localhost:8084/register',
        {
            username: username
        }).then(res => [
            console.log(res.data)
        ])
    }
    return(
        <div>
            <h1> Admin Page </h1>
            <h2>register</h2>
            <label>Username</label>
            <input type="text"
                        onChange={e => {
                            setUsername(e.target.value);
                            console.log(e.target.value)
                        }}
                    />
                    <button onClick={register}>Registration</button>
        </div>
    )
}

export default DanAdminPage;