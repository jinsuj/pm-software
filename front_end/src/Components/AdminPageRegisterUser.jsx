
import React, { useState, useEffect } from 'react';
import Axios from 'axios';



const AdminPageRegisterUser = () => {
    const [username, setUsername] = useState('');
    const [users, setUsers] = useState([]);
    const register = () => {
        Axios.post('http://localhost:8084/register',
        {
            username: username
        }).then(res => [
            console.log(res.data)
        ])
        
    }

    useEffect(() => {
        Axios.get('http://localhost:8084/getalluser')
            .then(res => {
                console.log(res);
                setUsers(res.data)
            })
    }, []);

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
           
           <div>
                {users.map(user => (
                    <div key={user.id}>
                        <h1>{user.username}</h1>
                        <h3>{user.id}</h3>
                    </div>
                    
                ))}
           </div>
            
        </div>
    )
}

export default AdminPageRegisterUser;