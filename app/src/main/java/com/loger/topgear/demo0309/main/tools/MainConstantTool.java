package com.loger.topgear.demo0309.main.tools;


import android.support.annotation.IntDef;

import static com.loger.topgear.demo0309.main.tools.MainConstantTool.E_ME;
import static com.loger.topgear.demo0309.main.tools.MainConstantTool.L_SHANGCHENG;
import static com.loger.topgear.demo0309.main.tools.MainConstantTool.O_SHEJIAO;
import static com.loger.topgear.demo0309.main.tools.MainConstantTool.S_SHOUYE;

@IntDef({S_SHOUYE,O_SHEJIAO,L_SHANGCHENG,E_ME})
public @interface MainConstantTool {   //@interface  注解型式

    int S_SHOUYE = 0;
    int O_SHEJIAO = 1;
    int L_SHANGCHENG = 2;
    int E_ME = 3;

}
