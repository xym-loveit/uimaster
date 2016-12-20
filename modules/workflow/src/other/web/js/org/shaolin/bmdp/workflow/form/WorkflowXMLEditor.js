/* null */
/* auto generated constructor */
function org_shaolin_bmdp_workflow_form_WorkflowXMLEditor(json)
{
    var prefix = (typeof(json) == "string") ? json : json.prefix; 
    var idUI = new UIMaster.ui.hidden
    ({
        ui: elementList[prefix + "idUI"]
    });

    var entityNameUI = new UIMaster.ui.hidden
    ({
        ui: elementList[prefix + "entityNameUI"]
    });

    var xmlContentUI = new UIMaster.ui.textarea
    ({
        ui: elementList[prefix + "xmlContentUI"]
        ,rows: 20
        ,cols: 90
    });

    var okbtn = new UIMaster.ui.button
    ({
        ui: elementList[prefix + "okbtn"]
    });

    var cancelbtn = new UIMaster.ui.button
    ({
        ui: elementList[prefix + "cancelbtn"]
    });

    var actionPanel = new UIMaster.ui.panel
    ({
        ui: elementList[prefix + "actionPanel"]
        ,items: []
        ,subComponents: [prefix + "okbtn",prefix + "cancelbtn"]
    });

    var fieldPanel = new UIMaster.ui.panel
    ({
        ui: elementList[prefix + "fieldPanel"]
        ,items: []
        ,subComponents: [prefix + "idUI",prefix + "entityNameUI",prefix + "xmlContentUI"]
    });

    var Form = new UIMaster.ui.panel
    ({
        ui: elementList[prefix + "Form"]
        ,items: [idUI,entityNameUI,xmlContentUI,okbtn,cancelbtn,fieldPanel,actionPanel]
    });

    Form.idUI=idUI;

    Form.entityNameUI=entityNameUI;

    Form.xmlContentUI=xmlContentUI;

    Form.okbtn=okbtn;

    Form.cancelbtn=cancelbtn;

    Form.fieldPanel=fieldPanel;

    Form.idUI=idUI;

    Form.entityNameUI=entityNameUI;

    Form.xmlContentUI=xmlContentUI;

    Form.actionPanel=actionPanel;

    Form.okbtn=okbtn;

    Form.cancelbtn=cancelbtn;

    Form.user_constructor = function()
    {
        /* Construct_FIRST:org_shaolin_bmdp_workflow_form_WorkflowXMLEditor */
        /* Construct_LAST:org_shaolin_bmdp_workflow_form_WorkflowXMLEditor */
    };

    Form.Save = org_shaolin_bmdp_workflow_form_WorkflowXMLEditor_Save;

    Form.Cancel = org_shaolin_bmdp_workflow_form_WorkflowXMLEditor_Cancel;

    Form.invokeDynamicFunction = org_shaolin_bmdp_workflow_form_WorkflowXMLEditor_invokeDynamicFunction;

    Form.__entityName="org.shaolin.bmdp.workflow.form.WorkflowXMLEditor";

    Form.init();
    return Form;
};

    /* EventHandler Functions */
/* Other_Func_FIRST:org_shaolin_bmdp_workflow_form_WorkflowXMLEditor */
/* Other_Func_LAST:org_shaolin_bmdp_workflow_form_WorkflowXMLEditor */

    /* auto generated eventlistener function declaration */
    function org_shaolin_bmdp_workflow_form_WorkflowXMLEditor_Save(eventsource,event) {/* Gen_First:org_shaolin_bmdp_workflow_form_WorkflowXMLEditor_Save */
        var o = this;
        var UIEntity = this;

        // cal ajax function. 

        UIMaster.triggerServerEvent(UIMaster.getUIID(eventsource),"saveDetail-20150801-235410",UIMaster.getValue(eventsource),o.__entityName);
    }/* Gen_Last:org_shaolin_bmdp_workflow_form_WorkflowXMLEditor_Save */


    /* auto generated eventlistener function declaration */
    function org_shaolin_bmdp_workflow_form_WorkflowXMLEditor_Cancel(eventsource,event) {/* Gen_First:org_shaolin_bmdp_workflow_form_WorkflowXMLEditor_Cancel */
        var o = this;
        var UIEntity = this;

        // cal ajax function. 

        UIMaster.triggerServerEvent(UIMaster.getUIID(eventsource),"cancelDetail-20150801-235410",UIMaster.getValue(eventsource),o.__entityName);
    }/* Gen_Last:org_shaolin_bmdp_workflow_form_WorkflowXMLEditor_Cancel */


    /* auto generated eventlistener function declaration */
    function org_shaolin_bmdp_workflow_form_WorkflowXMLEditor_invokeDynamicFunction(eventsource,event) {/* Gen_First:org_shaolin_bmdp_workflow_form_WorkflowXMLEditor_invokeDynamicFunction */
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
    }/* Gen_Last:org_shaolin_bmdp_workflow_form_WorkflowXMLEditor_invokeDynamicFunction */



