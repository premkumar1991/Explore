# Logging system design
    1. log can be classified to different levels error,info,verbose,warning
    2. log should be saved in file for later use
    3. log should be kept in some format, dd-mm-yyyy-hrs
    4. config: global level settings for logging should be there, meaning >= level will be perisited
        verbose>info>warnings>errors>fatal
    5. config: log collection time can be configured, to send it to remote server
    6. config: log retention policy on server can be configured, meaning how long it can be persisted in remote machine
    7. config: log directory can be configured
    8. log format: time,level, which class or namespace or fqdn
    9. destination type: console, textfile, database

> log can be navigated  from directory like -
>   log_directory/yyyy/mm/dd/00/application_log.log
> 
# example logs
`````[10/18/22, 11:19:54:324] info: Breadcrumb: electron: app.browser-window-focus
[10/18/22, 11:19:54:324] info: Breadcrumb: electron: app.browser-window-focus
[10/18/22, 11:19:54:324] info: Store: SET_WINDOW_FRAME
{
"id": 1,
"frame": {
"isFocused": true
},
"fromEvent": true
}
[10/18/22, 11:19:54:324] info: Store: SET_WINDOW_FRAME 
