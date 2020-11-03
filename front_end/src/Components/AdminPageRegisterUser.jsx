
import React, { useState, useEffect } from 'react';
import Axios from 'axios';



const AdminPageRegisterUser = () => {
    const [username, setUsername] = useState('');
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [userEmail, setEmail] = useState('');
    const [userRole, setRole] = useState('');
    const [userPassword, setPassword] = useState('');
    const [users, setUsers] = useState([]);
    const register = () => {
        Axios.post('http://localhost:8084/addNewUser',
        {
            username: username,
            firstName: firstName,
            lastName: lastName,
            email: userEmail,
            role: userRole,
            password: userPassword
        }).then(res => [
            console.log(res.data)
        ])
        
    }

    useEffect(() => {
        Axios.get('http://localhost:8084/list-users')
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
                    <input type="text"
                        onChange={e => {
                            setLastName(e.target.value);
                            console.log(e.target.value)
                        }}
                    />
                    <input type="text"
                        onChange={e => {
                            setFirstName(e.target.value);
                            console.log(e.target.value)
                        }}
                    />
                                <input type="email"
                        onChange={e => {
                            setEmail(e.target.value);
                            console.log(e.target.value)
                        }}
                    />
                                <input type="text"
                        onChange={e => {
                            setRole(e.target.value);
                            console.log(e.target.value)
                        }}
                    />
                                <input type="text"
                        onChange={e => {
                            setPassword(e.target.value);
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