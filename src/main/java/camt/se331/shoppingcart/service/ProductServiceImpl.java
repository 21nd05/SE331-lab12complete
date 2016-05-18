package camt.se331.shoppingcart.service;

import camt.se331.shoppingcart.dao.ProductDao;
import camt.se331.shoppingcart.entity.Image;
import camt.se331.shoppingcart.entity.Product;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Dto on 2/8/2015.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;
    @Override
    public List<Product> getProducts() {
        return productDao.getProducts();
    }



    @Override
    public Product getProduct(Long id) {
        return productDao.getProduct(id);
    }

    @Override
    public Product addProduct(Product product) {
        return productDao.addProduct(product);
    }

    @Override
    public Product deleteProduct(Long id) {
        Product product = getProduct(id);
        return productDao.deleteProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productDao.updateProduct(product);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productDao.getProductsByName(name);
    }

    @Override
    @Transactional
    public Product addImage(Product product, Image image) {
        image=ImageUtil.resizeImage(image,200);
        product.getImages().add(image);
        productDao.updateProduct(product);
        return product;
    }

    @Override
    @Transactional
    public Product deleteImage(Product product, Long imageid) {
        Set<Image> images = product.getImages();
        for (Iterator<Image> it = images.iterator(); it.hasNext(); ) {
            Image f = it.next();
            if (f.getId().equals(imageid)){
                product.getImages().remove(f);}
        }
        productDao.updateProduct(product);
        return product;
    }


}
