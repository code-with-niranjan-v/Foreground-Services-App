# Foreground App
## Steps for creating a Service
- Create subclass of service class
- override onBind() and return null
- override onStartCommand() and in this block you can implement the work you
want to do in the service(I am displaying a simple notification).
- IMPORTANT NOTE:
-  for API 34 and above, we need to specify service type both in manifest file
and in startForeground() method.
