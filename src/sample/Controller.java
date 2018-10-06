//package sample;
//
//import org.fourthline.cling.UpnpService;
//import org.fourthline.cling.UpnpServiceImpl;
//import org.fourthline.cling.controlpoint.ActionCallback;
//import org.fourthline.cling.model.action.ActionInvocation;
//import org.fourthline.cling.model.message.UpnpResponse;
//import org.fourthline.cling.model.message.header.UDADeviceTypeHeader;
//import org.fourthline.cling.model.meta.Service;
//
//
//import org.fourthline.cling.UpnpService;
//import org.fourthline.cling.model.meta.Device;
//import org.fourthline.cling.model.types.UDADeviceType;
//
//import java.util.concurrent.ScheduledFuture;
//
//public class Controller {
//    private Device device;
//    private UpnpService upnpService;
//    private ActionExecutor actionExecutor;
//    private ScheduledFuture scheduledFuture;
//
//
//
//    public void init() {
//        actionExecutor = new ActionExecutor(this);
//        upnpService = new UpnpServiceImpl();
//        upnpService.getRegistry().addListener(registryListener);
//        try {
//            upnpService.getRegistry().addDevice(createDevice());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        UDADeviceTypeHeader header = new UDADeviceTypeHeader(new UDADeviceType(Constants.DEVICE_NAME));
//        upnpService.getControlPoint().search(header);
//
//        Runtime.getRuntime().addShutdownHook(new Thread() {
//            @Override
//            public void run() {
//                upnpService.shutdown();
//            }
//        });
//    }
//
//    LocalDevice createDevice() throws ValidationException, LocalServiceBindingException, IOException {
//
//        DeviceIdentity identity =
//                new DeviceIdentity(
//                        UDN.uniqueSystemIdentifier("Demo Binary Light")
//                );
//
//        DeviceType type =
//                new UDADeviceType("BinaryLight", 1);
//
//        DeviceDetails details =
//                new DeviceDetails(
//                        "Friendly Binary Light",
//                        new ManufacturerDetails("ACME"),
//                        new ModelDetails(
//                                "BinLight2000",
//                                "A demo light with on/off switch.",
//                                "v1"
//                        )
//                );
//
//        Icon icon =
//                new Icon(
//                        "image/png", 48, 48, 8,
//                        getClass().getResource("icon.png")
//                );
//
//        LocalService<SwitchPower> switchPowerService =
//                new AnnotationLocalServiceBinder().read(SwitchPower.class);
//
//        switchPowerService.setManager(
//                new DefaultServiceManager(switchPowerService, SwitchPower.class)
//        );
//
//        return new LocalDevice(identity, type, details, icon, switchPowerService);
//
//    }
//
//}
