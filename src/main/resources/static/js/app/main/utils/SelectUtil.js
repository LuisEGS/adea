class SelectUtil{
    constructor() { }
    objTable;
    set objTable(value){
      this.objTable = value;
    }
    get objTable(){
      return this.objTable;
    }

    writeOptions(){
        let header = this.objTable.header ;
          let strOption = ``;
        let body = this.objTable.data;
        body.forEach(record => {
            let optVal = '';
            let optText = '';
            header.forEach(config =>{
                if(config.pk){
                    optVal = record[config.key]
                }
                if(config.desc){
                    optText = record[config.key]
                }
            });
            strOption += `<option value="${optVal}">${optText}</option>`
        }); 

        return strOption;
      }
}