import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Details from './Details';
import UserInput from './UserInput';
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



  componentDidMount() {
    axios.get('http://localhost:8080/api/details').then((response) => {
      this.setState({ appDetails: response.data })
    })
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
          <UserInput />
        </header>
        <Details users={this.state.users} />
      </div>
    );
  }
}

export default App;
