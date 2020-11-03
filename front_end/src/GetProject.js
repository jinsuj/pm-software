import React, { useState,useEffect } from 'react';
import axios from 'axios'
function GetProject() {
    const [projectName,setProjectName] = useState();
    const [projectDescription,setProjectDescription] = useState();
    const [projects,setProjects] = useState([]);
    const fetchProjects=()=>{
        axios.get('http://localhost:8084/getProjects').then(res=>setProjects(res.data))
    }

    useEffect(()=>{
        fetchProjects();
      });
    
      function deleteProject(project,index){
          console.log(index);
        axios.post('http://localhost:8084/deleteProject',project)
        .then(projects.splice(index, 1))
      }

    function creatProject(){
        console.log(projectName+"  "+projectDescription)
        const Obj={
            "name":projectName,
            "description":projectDescription
        }
        console.log(Object)
        axios.post('http://localhost:8084/createProject', Obj).then(res => console.log(res.data) )
    }
  return (
      <div className="container">
    <button type="button" class="btn btn-success" data-toggle="modal" data-target="#exampleModal">
    Create Project
  </button>
    <div id="exampleModal" class="modal" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <form>
  <div class="form-group">
    <label for="projectName">Project name</label>
    <input type="text" class="form-control" id="projectName" aria-describedby="textHelp" onChange={(e)=>setProjectName(e.target.value)}/>
    <small id="textHelp" class="form-text text-muted">This is the Project name</small>
  </div>
  <div class="form-group">
    <label for="projectDescription">Project description</label>
    <input type="text" class="form-control" id="projectDescription" onChange={(e)=>setProjectDescription(e.target.value)}/>
  </div>
</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onClick={creatProject}>Save changes</button>
      </div>
    </div>
  </div>
</div>
<form class="form-inline">
    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"/>
    <button class="btn btn-outline-success my-2 my-sm-0" type="button">Search</button>
  </form>
  <ul class="list-group">
      {projects.map((project,index)=>{return(<li class="list-group-item">{project.name}<small style={{float:"right",cursor:"pointer"}} onClick={()=>deleteProject(project,index)}>X</small></li>)})}
</ul>
</div>

  );
}

export default GetProject;