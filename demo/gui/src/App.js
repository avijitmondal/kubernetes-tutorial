import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Details from './Details';
import axios from 'axios';


class App extends Component {
  constructor(props) {
    super(props);

    this.state = {
      users: [],
      appDetails: {},
      name: "",
      id: 0
    };

  }

  fetchUsers(event) {
    // event.preventDefault();
    // const data = new FormData(event.target);
    // var id = data.get('id');
    // var name = data.get('name');
    // console.log(id);
    // console.log(name);
    // if ((id != null && id >= 10000 && id <= 20000) || (name != null && name.length === 0)) {
    axios.get('http://localhost:8080/api/users?name=avijit').then((response) => {
      this.setState({ users: response.data })
    })
    // }
  };

  componentDidMount() {
    axios.get('http://localhost:8080/api/details').then((response) => {
      this.setState({ appDetails: response.data })
    })
  };

  handleNameChange(event) {
  this.setState({ name: event.target.value });
  };
  
  handleIdChange(event) {
    this.setState({ id: event.target.value });
  };

render() {
  return (
    <div className="App" >
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>Details Service</p>
        <p>
          <li>Hostname : {this.state.appDetails.hostname}</li>
          <li>IP : {this.state.appDetails.ip}</li>
          <li>Port : {this.state.appDetails.port}</li>
        </p>
        <form onSubmit={this.fetchUsers} >
          <input name="id" type="number" placeholder="Id" value={this.state.id} onChange={this.handleIdChange} />
          <input name="name" type="text" placeholder="Name" value={this.state.name} onChange={this.handleNameChange} />
          <button onClick={this.fetchUsers}>Search</button>
        </form>
      </header>
      <Details users={this.state.users} />
    </div>
  );
}
}

export default App;
