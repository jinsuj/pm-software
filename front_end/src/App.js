import logo from './logo.svg';
import './App.css';
import AdminPage from './Components/AdminPageRegisterUser';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
function App() {
  return (
  <Switch>
    <Route exact path="/" component={AdminPage}/>
    {/* <PrivateRoute exact path="/app" component={AppLayout}/> */}
    <Route path="*" component={() => "404 NOT FOUND"}/>
  </Switch>
  );
}

export default App;
