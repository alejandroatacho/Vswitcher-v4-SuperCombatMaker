Widget levelUp = client.getWidget(233,0);
Widget muliSkillMenu = client.getWidget(270,0);

int unf_str = 2440;
int unf_atk = 2436;
int unf_def = 2442;
int torstol = 269;
int finished = 12695;
int vial = 229;
String pot_name = "Super combat potion (4)";

if(levelUp != null && (v.getInventory().amountInInventory(unf_str,1,7) || v.getInventory().amountInInventory(unf_atk,1,7) || v.getInventory().amountInInventory(unf_def,1,7))) {
    log.info("LEVEL UP");
    if(v.getInventory().amountInInventory(unf_str,1,7)) {
        v.getInventory().useOnItem(torstol, unf_str);
    } else if(v.getInventory().amountInInventory(unf_atk,1,7)) {
        v.getInventory().useOnItem(torstol, unf_atk);
    } else {
        v.getInventory().useOnItem(torstol, unf_def);
    }
    
    v.getCallbacks().afterTicks(3, () -> {
        v.invoke("Make","<col=ff9040>"+pot_name+"</col>",1,57,-1,17694734,false);
    });
}

if((v.getInventory().amountInInventory(unf_str,1,7) || v.getInventory().amountInInventory(unf_atk,1,7) || v.getInventory().amountInInventory(unf_def,1,7)) && !v.getInventory().amountInInventory(finished,1,27) && v.getLocalPlayer().hasAnimation(-1)) {
    if(v.getBank().isOpen()) {
        v.getBank().close();
    } else if(muliSkillMenu != null) { 
        v.invoke("Make","<col=ff9040>"+pot_name+"</col>",1,57,-1,17694734,false);
    } else {
        if(v.getInventory().amountInInventory(unf_str,1,7)) {
            v.getInventory().useOnItem(torstol, unf_str);
        } else if(v.getInventory().amountInInventory(unf_atk,1,7)) {
            v.getInventory().useOnItem(torstol, unf_atk);
        } else {
            v.getInventory().useOnItem(torstol, unf_def);
        }
    }
    
} else {
    if(v.getInventory().amountInInventory(finished,7,7)) {
        v.getBank().deposit(finished,7);
        v.getBank().deposit(vial,7);  // Deposit vial
    } else if(!v.getInventory().amountInInventory(unf_str,1,27) && !v.getInventory().amountInInventory(unf_atk,1,27) && !v.getInventory().amountInInventory(unf_def,1,27)) {
        v.getBank().withdraw(unf_str,7);
        v.getBank().withdraw(unf_atk,7);
        v.getBank().withdraw(unf_def,7);
        v.getBank().withdraw(torstol,7);
    }
}