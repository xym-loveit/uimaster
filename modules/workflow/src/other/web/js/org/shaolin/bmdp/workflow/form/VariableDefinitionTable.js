/* null */
/* auto generated constructor */
function org_shaolin_bmdp_workflow_form_VariableDefinitionTable(json)
{
    var prefix = (typeof(json) == "string") ? json : json.prefix; 
    var parentIdUI = new UIMaster.ui.hidden
    ({
        ui: elementList[prefix + "parentIdUI"]
    });

    var itemTable = new UIMaster.ui.objectlist
    ({
        ui: elementList[prefix + "itemTable"]
        ,editable: true
    });

    var fieldPanel = new UIMaster.ui.panel
    ({
        ui: elementList[prefix + "fieldPanel"]
        ,items: []
        ,subComponents: [prefix + "parentIdUI",prefix + "itemTable"]
    });

    var Form = new UIMaster.ui.panel
    ({
        ui: elementList[prefix + "Form"]
        ,items: [parentIdUI,itemTable,fieldPanel]
    });

    Form.parentIdUI=parentIdUI;

    Form.itemTable=itemTable;

    Form.fieldPanel=fieldPanel;

    Form.parentIdUI=parentIdUI;

    Form.itemTable=itemTable;

    Form.user_constructor = function()
    {
        /* Construct_FIRST:org_shaolin_bmdp_workflow_form_VariableDefinitionTable */
        /* Construct_LAST:org_shaolin_bmdp_workflow_form_VariableDefinitionTable */
    };

    Form.createItem = org_shaolin_bmdp_workflow_form_VariableDefinitionTable_createItem;

    Form.deleteItem = org_shaolin_bmdp_workflow_form_VariableDefinitionTable_deleteItem;

    Form.invokeDynamicFunction = org_shaolin_bmdp_workflow_form_VariableDefinitionTable_invokeDynamicFunction;

    Form.__entityName="org.shaolin.bmdp.workflow.form.VariableDefinitionTable";

    Form.init();
    return Form;
};

    /* EventHandler Functions */
/* Other_Func_FIRST:org_shaolin_bmdp_workflow_form_VariableDefinitionTable */
/* Other_Func_LAST:org_shaolin_bmdp_workflow_form_VariableDefinitionTable */

    /* auto generated eventlistener function declaration */
    function org_shaolin_bmdp_workflow_form_VariableDefinitionTable_createItem(eventsource,event) {/* Gen_First:org_shaolin_bmdp_workflow_form_VariableDefinitionTable_createItem */
        var o = this;
        var UIEntity = this;

        // cal ajax function. 

        UIMaster.triggerServerEvent(UIMaster.getUIID(eventsource),"createItem_20150807-230248",UIMaster.getValue(eventsource),o.__entityName);
    }/* Gen_Last:org_shaolin_bmdp_workflow_form_VariableDefinitionTable_createItem */


    /* auto generated eventlistener function declaration */
    function org_shaolin_bmdp_workflow_form_VariableDefinitionTable_deleteItem(eventsource,event) {/* Gen_First:org_shaolin_bmdp_workflow_form_VariableDefinitionTable_deleteItem */
        var o = this;
        var UIEntity = this;

        // cal ajax function. 

        UIMaster.triggerServerEvent(UIMaster.getUIID(eventsource),"deleteItem_20150807-230248",UIMaster.getValue(eventsource),o.__entityName);
    }/* Gen_Last:org_shaolin_bmdp_workflow_form_VariableDefinitionTable_deleteItem */


    /* auto generated eventlistener function declaration */
    function org_shaolin_bmdp_workflow_form_VariableDefinitionTable_invokeDynamicFunction(eventsource,event) {/* Gen_First:org_shaolin_bmdp_workflow_form_VariableDefinitionTable_invokeDynamicFunction */
        var o = this;
        var UIEntity = this;

        var constraint_result = this.Form.validate();
        if (constraint_result != true && constraint_result != null) {
            return false;
        }

        new UIMaster.ui.dialog({dialogType: UIMaster.ui.dialog.CONFIRM_DIALOG,message:WORKFLOW_COMFORMATION_MSG,messageType:UIMaster.ui.dialog.Warning,optionType:UIMaster.ui.dialog.YES_NO_OPTION,title:'',height:150,width:300,handler: function() {

        // cal ajax function. 

        UIMaster.triggerServerEvent(UIMaster.getUIID(eventsource),event,UIMaster.getValue(eventsource),o.__entityName);

        
        }
        }).open();
    }/* Gen_Last:org_shaolin_bmdp_workflow_form_VariableDefinitionTable_invokeDynamicFunction */



