class LoginModel extends BaseModel {
    objFunction;
    objTable={
        header:[
                {key:"id",label:"Id",visible:"true",pk:true,classPre:"proyClick",desc:false },
                {key:"nombre",label:"Proyecto",visible:"true",pk:false,classPre:null,desc:true },
                {key:"activo",label:"Activo",visible:"true",pk:false,classPre:null,desc:false },
        ],
        data:[]
    }
    set objFunction(value){
        this.objFunction = value;
    }
    get objFunction(){
        return this.objFunction;
    }
    constructor() { 
        super("Login");
    }

    getRecordById(id){
        return this.objTable.data.find( record => record.id === id );
    }
    processGrid(data){
        this.objTable.data = data;
    }
}