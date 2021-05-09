import React, { useState } from "react";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import axios from 'axios';

export default function UserInput() {
    const [id, setId] = useState("");
    const [name, setName] = useState("");
    const [users, setUsers] = useState("");

    function handleSubmit(event) {
        event.preventDefault();
        fetchUsers();
    }

    function fetchUsers() {
        if (id != null && id >= 10000 && id <= 20000) {
            try {
                restCall('http://localhost:8080/api/users?id=' + id);
                console.log(users);
            } catch (e) {
                console.log(e);
            }
        } else if (name != null && name.length === 0) {
            try {
                restCall('http://localhost:8080/api/users?name=' + name);
                console.log(users);
            } catch (e) {
                console.log(e);
            }
        }
    };

    function restCall(url) {
        axios.get(url)
            .then((response) => {
                setUsers(response.data)
            });

    }

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <Form.Group size="lg" controlId="id">
                    <Form.Label>ID</Form.Label>
                    <Form.Control
                        autoFocus
                        type="number"
                        value={id}
                        onChange={(e) => setId(e.target.value)}
                    />
                </Form.Group>
                <Form.Group size="lg" controlId="name">
                    <Form.Label>Name</Form.Label>
                    <Form.Control
                        type="text"
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                    />
                </Form.Group>
                <Button block size="lg" type="submit">
                    Find
                </Button>
            </form>
        </div>
    );
}

