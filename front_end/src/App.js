import logo from './logo.svg';
import './App.css';
import GetProject from './GetProject'
import { Route, Switch, BrowserRouter as Router, Link } from 'react-router-dom';
import AdminPageRegisterUser from './Components/AdminPageRegisterUser';


function App() {
  
  return (
    <Router>
          <Link className="nav-link" to="/GetProject" style={{ fontWeight:"bold"}}><big>Create Delete Project</big></Link>
    <div>
      <Switch>
        <Route exact={true} path="/GetProject" component={() => <GetProject />} />
        <Route exact path="/adminadd" component={AdminPageRegisterUser} />
      </Switch>
    </div>
  </Router>
  );
}

export default App;
