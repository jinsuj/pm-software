import logo from './logo.svg';
import './App.css';
import CreateProject from './CreateProject'
import { Route, Switch, BrowserRouter as Router, Link } from 'react-router-dom';


function App() {
  
  return (
    <Router>
          <Link className="nav-link" to="/CreateProject" style={{ fontWeight:"bold"}}><big>Create Delete Project</big></Link>
    <div>
      <Switch>
        <Route exact={true} path="/CreateProject" component={() => <CreateProject />} />
      </Switch>
    </div>
  </Router>
  );
}

export default App;
