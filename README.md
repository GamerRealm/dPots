# dPots
dPots is a lightweight and smooth pot enhancer plugin.

It is similar to FastPot but improved with cmds and configuration.

The code might not look perfect because I was planning on recoding it to a new plugin.

The plugin works fine and I haven't had any issues from my testing, it should work on 1.7+.

If there is any issue or you need help, DM me on discord @Dubai#1454

## Why Open Source it?
It's a really simple plugin so I decided to open source it.

People who paid for it will get something else so no one loses.

## Config
```yaml
#########################
#        dPots          #
#    By Dubai#1454      #
#########################

#Use the command /pot setspeed to update the pot speed
#Don't Change the data.yml use cmds!
#Suggested Range: 0.07 - 0.09

#Messages Config
MESSAGES:
  RELOAD: "&adPots has been reloaded!"
  POTION:
   SPEED-UPDATED: "&6Pot speed has been updated to &e<value>&6."
   OFFSET-UPDATED: "&6Pot offset has been updated to &e<value>&6."
   VALUES-MESSAGE:
     - "&7&m----------------------------"
     - "&6&lPotion Values"
     - " "
     - "&6Potion Offset&7: &f<offset>"
     - "&6Potion Speed&7: &f<speed>"
     - "&7&m----------------------------"

  HELP-MESSAGES:
    POTION:
    - "&7&m<line>"
    - "&6&lPotion Commands"
    - " "
    - "&6/pot setoffset  &7- &fSet the potion offset"
    - "&6/pot setspeed &7- &fSet the potion speed"
    - "&6/pot values  &7- &fView the potion values"
    - " "
    - "&cPlease check config recommendations"
    - "&cbefore setting up potion settings!"
    - "&7&m<line>"
#Values System:
#More = Faster | Less = Slower
```

## Screenshots
![2021-12-03_22 55 08](https://user-images.githubusercontent.com/42650369/144657793-487955cb-ab3e-42db-945d-d5d859df0357.png)
![2021-12-03_22 58 00](https://user-images.githubusercontent.com/42650369/144657890-f30c7842-62d9-4276-aeab-98a9c0fe7639.png)
