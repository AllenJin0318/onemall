package cn.iocoder.mall.productservice.rpc.spu;

import cn.iocoder.common.framework.vo.CommonResult;
import cn.iocoder.common.framework.vo.PageResult;
import cn.iocoder.mall.productservice.manager.spu.ProductSpuManager;
import cn.iocoder.mall.productservice.rpc.spu.dto.ProductSpuAndSkuCreateReqDTO;
import cn.iocoder.mall.productservice.rpc.spu.dto.ProductSpuAndSkuUpdateReqDTO;
import cn.iocoder.mall.productservice.rpc.spu.dto.ProductSpuPageReqDTO;
import cn.iocoder.mall.productservice.rpc.spu.dto.ProductSpuRespDTO;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static cn.iocoder.common.framework.vo.CommonResult.success;

/**
* 商品 SPU Rpc 实现类
*/
@DubboService
public class ProductSpuRpcImpl implements ProductSpuRpc {

    @Autowired
    private ProductSpuManager productSpuManager;

    @Override
    public CommonResult<Integer> createProductSpu(ProductSpuAndSkuCreateReqDTO createDTO) {
        return success(productSpuManager.createProductSpu(createDTO));
    }

    @Override
    public CommonResult<Boolean> updateProductSpu(ProductSpuAndSkuUpdateReqDTO updateDTO) {
        productSpuManager.updateProductSpu(updateDTO);
        return success(true);
    }

    @Override
    public CommonResult<ProductSpuRespDTO> getProductSpu(Integer productSpuId) {
        return success(productSpuManager.getProductSpu(productSpuId));
    }

    @Override
    public CommonResult<List<ProductSpuRespDTO>> listProductSpus(List<Integer> productSpuIds) {
        return success(productSpuManager.listProductSpus(productSpuIds));
    }

    @Override
    public CommonResult<PageResult<ProductSpuRespDTO>> pageProductSpu(ProductSpuPageReqDTO pageDTO) {
        return success(productSpuManager.pageProductSpu(pageDTO));
    }

    @Override
    public CommonResult<List<Integer>> listProductSpuIds(Integer limit, Integer lastSpuId) {
        return success(productSpuManager.listProductSpuIds(limit, lastSpuId));
    }

}
