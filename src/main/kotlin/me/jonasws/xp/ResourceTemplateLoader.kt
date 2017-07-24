package me.jonasws.xp

import com.enonic.xp.app.ApplicationKey
import com.enonic.xp.resource.Resource
import com.enonic.xp.resource.ResourceService
import de.neuland.jade4j.template.TemplateLoader
import java.io.Reader

class ResourceTemplateLoader(private val resourceService: ResourceService) : TemplateLoader {

    private fun getResource(name: String): Resource {
        val splitArray = name.split(":")
        val applicationKey = splitArray[0]
        val templatePath = splitArray[1]

        val resourceKeys = resourceService.findFiles(ApplicationKey.from(applicationKey), templatePath)
        return resourceService.getResource(resourceKeys[0])
    }


    override fun getReader(name: String): Reader = getResource(name).openReader()

    override fun getLastModified(name: String): Long = getResource(name).timestamp


}

