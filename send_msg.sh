#!/bin/bash

echo '
  <isomsg>
     <field id="0" value="0100"/>
     <field id="3" value="300000"/>
     <field id="4" value="000000043170"/>
     <field id="11" value="000236"/>
     <field id="12" value="124927"/>
     <field id="13" value="0605"/>
     <field id="22" value="022"/>
     <field id="24" value="003"/>
     <field id="25" value="00"/>
     <field id="35" value="123456789012345=0508123456789"/>
     <field id="41" value="29110001"/>
     <field id="42" value="000000000100001"/>
     <field id="49" value="840"/>
     <field id="62" value="062881"/>
    </isomsg>
' | nc localhost $1
