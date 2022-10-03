class LoginClass{
	login = new LoginModel();
	constructor(){}
	events(){
	
      let objEvent = this;

      let template = document.getElementById( "enviar" );
      template.addEventListener( "click", function() { objEvent.setLogin(); }, false );
	}
	
    setLogin(){
      let log = this.login;
      let base = this;
      let record = {};
	  record.usuario   = document.getElementById("usuario").value;
      record.password  = document.getElementById("clave").value;
      log.record = record;
      
      
      log.newRecord().then(response => {
		debugger;
		console.log(response);
		
		if(response.data.error){
			alert(response.data.ErrorDesc);			
		}else{
			window.location.href = "tablero"; 
		}
		
		
      }).catch(error => {

      });
    }
}