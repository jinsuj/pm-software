import logo from './logo.svg';
import './App.css';
import DanAdminPage from './Components/DanAdminPage';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
function App() {
  return (
  <Switch>
    <Route exact path="/" component={DanAdminPage}/>
    {/* <PrivateRoute exact path="/app" component={AppLayout}/> */}
    <Route path="*" component={() => "404 NOT FOUND"}/>
  </Switch>
  );
}

export default App;
