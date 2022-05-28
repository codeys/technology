package com.technical.terchnicalsummary.webservice.service.impl;

import com.technical.terchnicalsummary.webservice.dto.UserDto;
import com.technical.terchnicalsummary.webservice.service.UserService;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * WebService涉及到的有这些 "四解三类 ", 即四个注解，三个类
 *
 * @WebMethod
 * @WebService
 * @WebResult
 * @WebParam SpringBus
 * Endpoint
 * EndpointImpl
 * <p>
 * 一般我们都会写一个接口，然后再写一个实现接口的实现类，但是这不是强制性的
 * @WebService 注解表明是一个webservice服务。
 * name：对外发布的服务名, 对应于<wsdl:portType name="ServerServiceDemo"></wsdl:portType>
 * targetNamespace：命名空间,一般是接口的包名倒序, 实现类与接口类的这个配置一定要一致
 * Exception in thread "main" org.apache.cxf.common.i18n.UncheckedException: No operation was found with the name xxxx
 * 对应于targetNamespace="http://server.webservice.example.com"
 * endpointInterface：服务接口全路径（如果是没有接口，直接写实现类的，该属性不用配置）, 指定做SEI（Service EndPoint Interface）服务端点接口
 * serviceName：对应于<wsdl:service name="ServerServiceDemoImplService"></wsdl:service>
 * portName：对应于<wsdl:port binding="tns:ServerServiceDemoImplServiceSoapBinding" name="ServerServiceDemoPort"></wsdl:port>
 * @WebMethod 表示暴露的服务方法, 这里有接口ServerServiceDemo存在，在接口方法已加上@WebMethod, 所以在实现类中不用再加上，否则就要加上
 * operationName: 接口的方法名
 * action: 没发现又什么用处
 * exclude: 默认是false, 用于阻止将某一继承方法公开为web服务
 * @WebResult 表示方法的返回值
 * name：返回值的名称
 * partName：
 * targetNamespace:
 * header: 默认是false, 是否将参数放到头信息中，用于保护参数，默认在body中
 * @WebParam name：接口的参数
 * partName：
 * targetNamespace:
 * header: 默认是false, 是否将参数放到头信息中，用于保护参数，默认在body中
 * model：WebParam.Mode.IN/OUT/INOUT
 */
@WebService(name = "userPortType", targetNamespace = "http://server.webservice.example.com",
        serviceName = "userService",           //服务name名称
        portName = "userPortName",             //port名称
        endpointInterface = "com.technical.terchnicalsummary.webservice.service.UserService")
public class UserServiceImpl implements UserService {
    @Override
    public UserDto get(String id) {
        if (null == id) {
            return null;
        }

        List<UserDto> list = getData();
        UserDto UserDto = null;
        for (UserDto user : list
        ) {
            if (id.equals(user.getUserId().toString())) {
                UserDto = user;
                break;
            }
        }

        return UserDto;
    }

    @Override
    public List<UserDto> list() {
        List<UserDto> list = new ArrayList<>();

        list = getData();

        return list;
    }

    @Override
    public int count() {
        return getData().size();
    }

    @Override
    public int save(UserDto user) {
        return 1;
    }

    @Override
    public int update(UserDto user) {
        return 1;
    }

    @Override
    public int remove(Integer id) {
        return 1;
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return 1;
    }

    /**
     * 模拟一组数据
     */
    private List<UserDto> getData() {
        List<UserDto> list = new ArrayList<>();

        UserDto UserDto = new UserDto();
        UserDto.setUserId(1);
        UserDto.setUserName("admin");
        list.add(UserDto);

        UserDto = new UserDto();
        UserDto.setUserId(2);
        UserDto.setUserName("heike");
        list.add(UserDto);

        UserDto = new UserDto();
        UserDto.setUserId(3);
        UserDto.setUserName("tom");
        list.add(UserDto);

        UserDto = new UserDto();
        UserDto.setUserId(4);
        UserDto.setUserName("mac");
        list.add(UserDto);

        return list;
    }
}
